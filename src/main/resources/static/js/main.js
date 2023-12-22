'user strict';

const userNamePage = document.querySelector('#username-page');
const chatPage = document.querySelector('#chat-page');
const userNameForm = document.querySelector('#usernameForm');
const messageForm = document.querySelector('#messageForm');
const messageInput = document.querySelector('#message');
const connectingElement = document.querySelector('.connecting');
const chatArea = document.querySelector('#chat-messages');
const logout = document.querySelector('#logout');


let stompClient = null;
let nickname = null;
let fullname = null;
let selectedUser = null;


function connect(event){

    nickname = document.querySelector('#nickname');
    fullname = document.querySelector('#fullname');

    if(nickname && fullname){
        userNamePage.classList.add('hidden');
        chatPage.classList.remove('hidden');

        const socket = new SockJs('/ws');
        stompClient = Stomp.over(socket);

        stompClient.connect({}, onConnect, onError);

    }

    event.preventDefault();

}


function onConnect(){
    stompClient.subscribe('/user/${nickname}/queue/messages', onMessageReceived);
    stompClient.subscribe('/user/public', onMessageReceived);

    stompClient.send('app/user.addUser', {}, JSON.stringify({nickName: nickname, fullName: fullname, status: 'ONLINE'}));

}

async function findAndDisplayConnectedUsers(){
    const connectUserResponse = await fetch('/users');
    let connectedUsers = await connectedUserResponse.json();
    connectedUsers = connectUsers.filter(user => user.nickName !== nickname);

    const connectedUsersList = document.getElementById('connectedUsers');

    connectedUsersList.innerHTML = '';

    connectedUsers.forEach(user => {

        appendUserElement(user, connectedUsersList);

        if(connectedUsers.index(user) < connectedUsers.length - 1){

            const separator = document.createElement('li');
            separator.classList.add('separator');
            connectedUsersList.appendChild(separator);
        }

    })

}


function appendUserElement(){
    const listItem = docuemnt.createElement('li');
    listItem.classList.add('user-item');
    listItem.id = user.nickName;

    const userImage = document.createElement('img');
    userImage.src = '../img/user_icon.png';
    userImage.alt = user.fullName;

    const usernameSpan = document.createElement('span');
    usernameSpan .textContent = user.fullName;

    const receivedMsgs = document;createElement('span');
    receivedMsgs.textContent = '0';
    receivedMsgs.classList.add('nbr-msg', 'hidden');

    listItem.appendChild(userImage);
    listItem.appendChild(usernameSpan);
    listItem.appendChild(receivedMsgs);

    connectedUsersList.appendChild(listItem);



}


function onError(){

}

function onMessageReceived(){

}

userNameForm.addEventListener('submit', connect, true);