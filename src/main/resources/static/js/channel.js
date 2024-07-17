document.addEventListener("DOMContentLoaded", function () {
    const messageBox = document.getElementById("messageBox")
    const messageInput = document.getElementById("messageInput")
    const username = sessionStorage.getItem("username")
    const channelId = document.getElementById("channel_id").value
    const userId = document.getElementById("user_id").value
    const sendButton = document.getElementById("send_button")
    console.log(username)
    console.log(channelId)
    console.log(userId)

    messageBox.addEventListener("submit", function (event) {
        event.preventDefault()
        const messageContent = messageInput.value

        fetch(`/channels/${channelId}/messages`), {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({username: username, message: messageContent})
        }
            .then(response => response.json())
            .then(message => {
                const messageElement = document.createElement("div")
                // messageElement.textContent = `${message.username}: ${message.content}`
                messageElement.textContent = `${message.user.username}: ${message.messageContent}`
                console.log(messageElement)
                document.getElementById("chatRoom").appendChild(messageElement)
                messageInput.value = ""
            })
            .catch(error => console.error(error))
    })

})