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
let nickName = null;
let fullname = null;
let selectedUser = null