
document.addEventListener("DOMContentLoaded", function () {
    const messageBox = document.getElementById("messageBox");
    const messageInput = document.getElementById("messageInput");
    const username = sessionStorage.getItem("username");
    const channelId = document.getElementById("channel_id").value;
    const userId = sessionStorage.getItem("userId")
    const sendButton = document.getElementById("send_button");
    console.log("Username: " + username);
    console.log("ChannelId: " + channelId);
    console.log("UserId: " + userId);

    // if (!username || !channelId) {
    //     window.location.href = "/welcome";
    // } else {
    //     fetchMessages(channelId);
    // }

    messageBox.addEventListener("submit", function (event) {
        event.preventDefault();
        const messageContent = messageInput.value;

        fetch(`/channels/${channelId}/messages`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ username: username, messageContent: messageContent })
        })
            .then(response => response.json())
            .then(message => {
                const messageElement = document.createElement("div");
                messageElement.textContent =  `${message.user.username}: ${message.messageContent}`;
                console.log(messageElement);
                document.getElementById("chatRoom").appendChild(messageElement);
                messageInput.value = "";
                console.log("Username: " + username);
                console.log("ChannelId: " + channelId);
                console.log("UserId: " + userId);
            })
            .catch(error => console.error('Error:', error));
    });
});

function fetchMessages(channelId) {
    fetch(`/channels/${channelId}/messages`)
        .then(response => response.json())
        .then(messages => {
            const chatRoom = document.getElementById("chatRoom");
            chatRoom.innerHTML = "";
            messages.forEach(message => {
                const messageElement = document.createElement("div");
                messageElement.textContent = `${message.user.username}: ${message.messageContent}`;
                chatRoom.appendChild(messageElement);
            });
            scrollToBottom();
        })
        .catch(error => console.error('Error fetching the channel messages:', error));
}

function scrollToBottom() {
    const chatRoom = document.getElementById("chatRoom");
    chatRoom.scrollTop = chatRoom.scrollHeight;
}

document.addEventListener("DOMContentLoaded", function () {
    const channelId = document.getElementById("channel_id").value;
    setInterval(function() {
        fetchMessages(channelId);
    }, 100);
});



// document.addEventListener("DOMContentLoaded", init);
//
// function init() {
//     let userId = sessionStorage.getItem("userId");
//     let username = sessionStorage.getItem("username");
//     let channelId = document.getElementById("channelId");
//
//     if (!userId || !username) {
//         window.location.href = "/welcome";
//         return;
//     }
//
//     console.log("Username: " + username);
//     console.log("ChannelId: " + channelId);
//     console.log("UserId: " + userId);
//
//     // Initialize chat or other functionality here
//     initializeChat(channelId, username);
// }
//
// function initializeChat(channelId, username) {
//     const messageBox = document.getElementById("message_box");
//     const messageInput = document.getElementById("message_input");
//     const sendButton = document.getElementById("send_button");
//
//     sendButton.addEventListener("click", function () {
//         const messageContent = messageInput.value;
//
//         fetch(`/channels/${channelId}/messages`, {
//             method: 'POST',
//             headers: {
//                 'Content-Type': 'application/json'
//             },
//             body: JSON.stringify({ username: username, messageContent: messageContent })
//         })
//             .then(response => response.json())
//             .then(message => {
//                 const messageElement = document.createElement("div");
//                 messageElement.textContent = `${message.user.username}: ${message.messageContent}`;
//                 document.getElementById("chatRoom").appendChild(messageElement);
//                 messageInput.value = "";
//             })
//             .catch(error => console.error('Error:', error));
//     });
//
//     // Fetch messages periodically or use WebSocket
//     fetchMessages(channelId);
// }
//
// function fetchMessages(channelId) {
//     fetch(`/channels/${channelId}/messages`)
//         .then(response => response.json())
//         .then(messages => {
//             const chatRoom = document.getElementById("chatRoom");
//             chatRoom.innerHTML = "";
//             messages.forEach(message => {
//                 const messageElement = document.createElement("div");
//                 messageElement.textContent = `${message.user.username}: ${message.messageContent}`;
//                 chatRoom.appendChild(messageElement);
//             });
//             scrollToBottom();
//         })
//         .catch(error => console.error('Error fetching the channel messages:', error));
// }
//
// function scrollToBottom() {
//     const chatRoom = document.getElementById("chatRoom");
//     chatRoom.scrollTop = chatRoom.scrollHeight;
// }

