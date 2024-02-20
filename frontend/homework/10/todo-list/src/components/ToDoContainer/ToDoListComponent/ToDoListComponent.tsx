import React, { Dispatch, SetStateAction } from "react";
import "./ToDoListComponent.scss";

interface IToDoListProps {
    todoList: string[];
    setTodoList: Dispatch<SetStateAction<string[]>>;
    searchString: string;
}

const ToDoListComponent = ({
    todoList,
    setTodoList,
    searchString,
}: IToDoListProps) => {
    const handleDelete = (index: number) => {
        setTodoList(todoList.filter((_, i) => i !== index));
    };

    if (todoList.length === 0)
        return (
            <div className='no-todo-container'>
                <h1 className='no-todo-tag'>You are free 🥳</h1>
            </div>
        );

    if (todoList.filter((todo) => todo.startsWith(searchString)).length === 0)
        return (
            <div className='no-todo-container'>
                <h1 className='no-todo-tag'>No match found!</h1>
            </div>
        );

    return (
        <div className='todo-list-wrapper'>
            <h1>Items</h1>
            {todoList
                .filter((todo) => todo.startsWith(searchString))
                .map((todo, index) => (
                    <div key={index} className='todo-container'>
                        <h1 className='todo'>{todo}</h1>
                        <button
                            id='delete-todo'
                            onClick={() => handleDelete(index)}
                        >
                            X
                        </button>
                    </div>
                ))}
        </div>
    );
};

export default ToDoListComponent;
