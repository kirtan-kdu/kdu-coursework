import React, { Dispatch, SetStateAction, useState } from "react";
import "./AddToDoComponent.scss";

interface ISearchStringProp {
    todoList: string[];
    setToDoList: Dispatch<SetStateAction<string[]>>;
}

const AddToDoComponent = ({ todoList, setToDoList }: ISearchStringProp) => {
    const [inputValue, setInputValue] = useState("");

    const handleInputchange = (event: React.ChangeEvent<HTMLInputElement>) => {
        setInputValue(event.target.value);
    };
    const handleSubmit = () => {
        setToDoList([...todoList, inputValue]);
        setInputValue("");
        console.log(todoList);
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
