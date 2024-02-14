
const socket = io("http://localhost:5000");

const sendButton = document.querySelector(".send-btn");
const inputText = document.querySelector(".input-message");
const messagesSection = document.querySelector(".messages");

sendButton.addEventListener("click", (e) => {
    e.preventDefault();
    const messageText = inputText.value;
    messageText.length>0 && socket.emit("message", messageText) && addMessage("you", messageText);
    inputText.value = "";
})

socket.on("new-message", (message)=>{
    addMessage("user", message);
})

const addMessage = (className, message) => {

    console.log(className, message);
    const newDiv = document.createElement("div");
    const newText = document.createElement("h2");

    newText.textContent = message;
    newDiv.appendChild(newText);
    newDiv.classList.add("message", className);

    messagesSection.appendChild(newDiv);
}

