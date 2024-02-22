import { useContext } from "react";
import "./ToDoListComponent.scss";
import { SearchInputContext } from "../../../contexts/SearchInputProvider";
import { ToDoListContext } from "../../../contexts/TodoListProvider";

const ToDoListComponent = () => {
    const { todoList, setTodoList } = useContext(ToDoListContext);
    const { searchInput } = useContext(SearchInputContext);

    const handleDelete = (index: number) => {
        setTodoList(todoList.filter((_, i) => i !== index));
    };

    if (todoList.filter((todo) => todo.startsWith(searchInput)).length === 0)
        return (
            <div className='no-todo-container'>
                <h1 className='no-todo-tag'>
                    {todoList.length === 0
                        ? "You are free 🥳"
                        : "No match found!"}
                </h1>
            </div>
        );

    return (
        <div className='todo-list-wrapper'>
            <h1>Items</h1>
            {todoList
                .filter((todo) => todo.startsWith(searchInput))
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
