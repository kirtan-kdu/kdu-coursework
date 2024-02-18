
const submitBtn = document.querySelector(".submit-btn")
const usernameInput = document.querySelector(".username");
const passwordInput = document.querySelector(".password");
const invalidMessage = document.querySelector("#invalid-message")

submitBtn.addEventListener("click", () => {
    if(usernameInput.value == "" || passwordInput == "")return;

    const user = {
        username: usernameInput.value,
        password: passwordInput.value
    }

    fetch("http://localhost:5000/api/users/login", {
        method: "POST",
        body: JSON.stringify(user),
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        }
    })
    .then(response => {
        if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
        }
        return response.json();
    })
    .then(data => {
        sessionStorage.setItem("username", user.username);
        window.location.replace("http://localhost:5500/public/home-page");

    })
    .catch(error => {
        passwordInput.classList.add("invalid");
        usernameInput.classList.add("invalid")
        invalidMessage.style.display = "block"
        console.log("it has come in error");
    });
})

