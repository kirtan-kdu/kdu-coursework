import React, { useContext, useState } from "react";
import "./AddToDoComponent.scss";
import { ToDoListContext } from "../../../contexts/TodoListProvider";

const AddToDoComponent = () => {
    const [inputValue, setInputValue] = useState("");

    const { todoList, setTodoList } = useContext(ToDoListContext);

    const handleInputchange = (event: React.ChangeEvent<HTMLInputElement>) => {
        setInputValue(event.target.value);
    };
    const handleSubmit = () => {
        setTodoList([...todoList, inputValue]);
        setInputValue("");
    };

    return (
        <div className='add-todo-container'>
            <h1 className='add-todo-tag'>Add Items</h1>
            <div className='add-todo-input-container'>
                <input
                    value={inputValue}
                    type='text'
                    placeholder='Add item...'
                    id='todo-input'
                    onChange={(event) => handleInputchange(event)}
                />
                <button onClick={handleSubmit}>Add</button>
            </div>
        </div>
    );
};

export default AddToDoComponent;
