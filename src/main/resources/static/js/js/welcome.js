// document.addEventListener("DOMContentLoaded", function () {
//     let username = sessionStorage.getItem('username');
//     if (!username) {
//         username = prompt("Enter your username:");
//         if (username) {
//             sessionStorage.setItem("username", username);
//             console.log("Username set in local storage: " + username);
//             fetch('/welcome', {
//                 method: 'POST',
//                 headers: {
//                     'Content-Type': 'application/json'
//                 },
//                 body: JSON.stringify({username: username})
//             })
//                 .then(response => {
//                     if (!response.ok) {
//                         throw new Error('Network response was not ok');
//                     }
//                     return response.json();
//                 })
//                 .then(user => {
//                     sessionStorage.setItem("userId", user.userId);
//                     console.log("UserId set in session storage: " + user.userId);
//                     if (window.location.pathname !== '/welcome'){
//                         window.location.href = "/welcome";
//                     }
//                 })
//                 .catch(error => console.error('Fetch error:', error));
//             sessionStorage.removeItem('username')
//             sessionStorage.removeItem('userId')
//         } else {
//             alert("Username cannot be empty, please enter a valid username");
//         }
//     } else {
//         console.log("Username already set in local storage: " + username);
//     }
// });

document.addEventListener("DOMContentLoaded", init);

function init() {
    let username = sessionStorage.getItem('username');
    if (username) {
        handleExistingUser(username);
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
    fetch('/welcome', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({username: username})
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
            console.log("Username set in session storage: " + user.username);
            console.log("UserId set in session storage: " + user.userId);
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

function handleExistingUser(username) {
        console.log("Username already set in session storage: " + username);
        redirectToWelcome();
}