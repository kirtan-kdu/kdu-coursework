import "./ToDoListComponent.scss";
import { useDispatch, useSelector } from "react-redux";
import { RootState } from "../../../redux/Stores";
import { removeTodo } from "../../../redux/TodoListSlice";

const ToDoListComponent = () => {
    const todoList = useSelector((state: RootState) => state.TodoList.todoList);

    const reduxDispatch = useDispatch();

    const searchInput = useSelector(
        (state: RootState) => state.SearchInput.searchInput
    );

    const handleDelete = (index: number) => {
        reduxDispatch(removeTodo(index));
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
