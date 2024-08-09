
function generateUniqueSessionId() {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
        var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
        return v.toString(16);
    });
}


document.addEventListener("DOMContentLoaded", init);

function init() {
    let userId = sessionStorage.getItem("userId");
    let username = sessionStorage.getItem("username");

    console.log("Initializing with UserId: " + userId + " and Username: " + username);

    if (userId && username) {
        sessionStorage.setItem("userId", userId);
        sessionStorage.setItem("username", username);
        console.log("Username set in session storage: " + username);
        console.log("UserId set in session storage: " + userId);
        handleExistingUser()
    } else {
        promptForUsername();
    }
}

function promptForUsername() {
    let username = '';
    while (!username) {
        username = prompt("Enter your username:");
        if (username) {
            saveUsername(username);
        } else {
            alert("Username cannot be empty, please enter a valid username");
        }
    }
}

function saveUsername(username) {

    const sessionId = generateUniqueSessionId();
    console.log("SessionId: " + sessionId);
    sessionStorage.setItem('sessionId', sessionId);

    fetch('/welcome', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({username: username, sessionId: sessionId})
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(user => {
            sessionStorage.setItem("userId", user.userId);
            sessionStorage.setItem("username", user.username);
            sessionStorage.setItem("sessionId", sessionId);
            console.log("Username set in session storage after PostMapping welcome method: " + user.username);
            console.log("UserId set in session storage after PostMapping welcome method: " + user.userId);
            console.log("SessionId set in session storage after PostMapping welcome method: " + sessionId);
            redirectToWelcome();
        })
        .catch(error => {
            console.error('Fetch error:', error);
            // sessionStorage.removeItem('username');
            // sessionStorage.removeItem('userId');
            promptForUsername();
        });
}

function redirectToWelcome() {
    if (window.location.pathname !== '/welcome') {
        window.location.href = "/welcome";
    }
}

document.addEventListener("DOMContentLoaded", function() {
    const channelLinks = document.querySelectorAll(".channel-link");
    channelLinks.forEach(link => {
        link.addEventListener("click", function(event) {
            event.preventDefault();
            const channelId = this.getAttribute("data-channel-id");
            const sessionId = sessionStorage.getItem("sessionId");
            window.location.href = `/channels/${channelId}?sessionId=${sessionId}`;
        });
    });
});

function handleExistingUser(username) {
        console.log("Username already set in session storage: " + username);
        redirectToWelcome();
}