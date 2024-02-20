import React, { useState } from "react";
import AddToDoComponent from "./AddToDoComponent/AddToDoComponent";
import ToDoListComponent from "./ToDoListComponent/ToDoListComponent";
import "./ToDoComponent.scss";

interface ISearchStringProp {
    searchString: string;
}

const ToDoComponent = ({ searchString }: ISearchStringProp) => {
    const [todoList, setTodoList] = useState<string[]>([]);

    return (
        <div className='todolist-wrapper'>
            <div className='todolist-container'>
                <AddToDoComponent
                    todoList={todoList}
                    setToDoList={setTodoList}
                ></AddToDoComponent>
                <ToDoListComponent
                    todoList={todoList}
                    setTodoList={setTodoList}
                    searchString={searchString}
                ></ToDoListComponent>
            </div>
        </div>
    );
};

export default ToDoComponent;
