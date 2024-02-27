import React, { useState } from "react";
import "./AddToDoComponent.scss";
import { useDispatch } from "react-redux";
import { addTodo } from "../../../redux/TodoListSlice";

const AddToDoComponent = () => {
    const [inputValue, setInputValue] = useState("");

    const reduxDispatch = useDispatch();
    const handleInputchange = (event: React.ChangeEvent<HTMLInputElement>) => {
        setInputValue(event.target.value);
    };
    const handleSubmit = () => {
        reduxDispatch(addTodo(inputValue));
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
                <button
                    className='add-todo-btn'
                    disabled={inputValue === ""}
                    onClick={handleSubmit}
                >
                    Add
                </button>
            </div>
        </div>
    );
};

export default AddToDoComponent;
