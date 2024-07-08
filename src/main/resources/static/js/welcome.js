let username = prompt("Enter your name");

if (username) {
    fetch('welcome/save)', {
        method: 'POST',

        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({username})
    })
        .then(response => response.text())
        .then(data => alert(data))
        .catch(error => console.error(error));
}