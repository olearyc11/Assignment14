document.addEventListener("DOMContentLoaded", function() {
    let username = sessionStorage.getItem('username');
    if (!username) {
        while (!username) {
            username = prompt("Enter your username:");
            if (username) {
                sessionStorage.setItem("username", username);
                console.log("Username set in local storage: " + username);
                fetch('/welcome', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify( {username: username} )
                })
                    .then(response => {
                        if (!response.ok) {
                            throw new Error('Network response was not ok');
                        }
                        return response.json();
                    })
                    .then(user => {
                        sessionStorage.setItem("userId", user.userId);
                        console.log("UserId set in session storage: " + user.userId);
                        window.location.href = "/welcome";
                    })
                    .catch(error => console.error('Fetch error:', error));
            } else {
                alert("Username cannot be empty, please enter a valid username");
            }
        }
    }
});