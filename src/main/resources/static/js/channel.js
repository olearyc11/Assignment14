document.addEventListener("DOMContentLoaded", function() {
    const messageBox = document.getElementById("messageBox");
    const messageInput = document.getElementById("messageInput");
    const username = sessionStorage.getItem("username")
    console.log(username)


    // messageBox.addEventListener("submit", function(event) {
    //     event.preventDefault();
    //
    //     fetch('/chat', {
    //         method: 'POST',
    //         headers: {
    //             'Content-Type': 'application/json'
    //         },
    //         body: JSON.stringify( {username: username, message: messageContent} )
    //     })
    //         .then(response => response.text())
    //         .catch(error => console.error(error))
    // })

    messageBox.addEventListener("submit", function(event) {
        event.preventDefault()
        const messageContent = messageInput.value

        fetch(`/channels/${channelId}/messages`), {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({username: username, message: messageContent})
        }
            .then(response => response.text())
            .catch(error => console.error(error))
    })

})