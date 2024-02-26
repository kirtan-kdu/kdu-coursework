import AddToDoComponent from "./AddToDoComponent/AddToDoComponent";
import ToDoListComponent from "./ToDoListComponent/ToDoListComponent";
import "./ToDoComponent.scss";
import { Provider } from "react-redux";
import { store } from "../../redux/Stores";

const ToDoComponent = () => {
    return (
        <Provider store={store}>
            <div className='todolist-wrapper'>
                <div className='todolist-container'>
                    <AddToDoComponent />
                    <ToDoListComponent />
                </div>
            </div>
        </Provider>
    );
};

export default ToDoComponent;
