import React from "react";
import "./App.css";
import HeaderComponent from "./components/HeaderComponent/HeaderComponent";
import ToDoComponent from "./components/ToDoContainer/ToDoComponent";
import { Provider } from "react-redux";
import { store } from "./redux/Stores";

function App() {
    return (
        <Provider store={store}>
            <HeaderComponent />
            <ToDoComponent />
        </Provider>
    );
}

export default App;
