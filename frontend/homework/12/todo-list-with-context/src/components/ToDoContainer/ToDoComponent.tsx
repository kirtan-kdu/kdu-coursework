import AddToDoComponent from "./AddToDoComponent/AddToDoComponent";
import ToDoListComponent from "./ToDoListComponent/ToDoListComponent";
import "./ToDoComponent.scss";
import { TodoListProvider } from "../../contexts/TodoListProvider";

const ToDoComponent = () => {
    return (
        <TodoListProvider>
            <div className='todolist-wrapper'>
                <div className='todolist-container'>
                    <AddToDoComponent />
                    <ToDoListComponent />
                </div>
            </div>
        </TodoListProvider>
    );
};

export default ToDoComponent;
