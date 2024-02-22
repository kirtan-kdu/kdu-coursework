import React from "react";
import "./App.css";
import HeaderComponent from "./components/HeaderComponent/HeaderComponent";
import ToDoComponent from "./components/ToDoContainer/ToDoComponent";
import { SearchInputProvider } from "./contexts/SearchInputProvider";

function App() {
    return (
        <SearchInputProvider>
            <HeaderComponent />
            <ToDoComponent />
        </SearchInputProvider>
    );
}

export default App;
