document.addEventListener("DOMContentLoaded", function() {
    let username = sessionStorage.getItem('username')
    if (!username) {
        while (!username) {
            username = prompt("Enter your username:")
            if (username) {
                sessionStorage.setItem("username", username)
                let sessionUsername = sessionStorage.getItem("username")
                console.log("Username set in session storage: " + sessionUsername)
                fetch('/welcome', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify( {username: username} )
                })
                    .then(response => response.text())
                    .catch(error => console.error(error))
            } else {
                alert("Username cannot be empty, please enter a valid username")
            }
        }
    }
})