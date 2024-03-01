const todoButton = document.querySelector(".add-todo");
const todoNameInput = document.querySelector("#todo-input");
const todoListContainer = document.querySelector(".todos");

// Check if elements exist before adding event listeners
if (todoButton && todoNameInput && todoListContainer) {
  // Event listener for adding todos
  todoButton.addEventListener("click", () => {
    const todoValue = todoNameInput.value.trim();
    if (!todoValue) return;

    const todoContainer = document.createElement("div");
    const deleteButton = document.createElement("button");
    deleteButton.className = "delete-todo";
    deleteButton.textContent = "Delete";

    // Event listener for deleting todos
    deleteButton.addEventListener("click", () => {
      todoListContainer.removeChild(todoContainer);
    });

    const newTodo = document.createElement("h3");
    newTodo.textContent = todoValue;
    todoContainer.appendChild(newTodo);
    todoContainer.appendChild(deleteButton);
    todoListContainer.appendChild(todoContainer);
    todoNameInput.value = "";
  });
}

// Example usage of a promise-related functionality
const promiseButton = document.querySelector(".promise-button");
if (promiseButton) {
  promiseButton.addEventListener("click", async () => {
    try {
      const result = await generatePromiseFunction();
      console.log(result);
    } catch (error) {
      console.error('Error:', error);
    }
  });
}

async function generatePromiseFunction() {
      console.log('Starting...');
      setTimeout(() => {console.log('...Finished waiting for  5 seconds')} ,5000)
      
  return Promise.resolve('Data from promise');
}
