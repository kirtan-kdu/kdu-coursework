import React, { useState } from "react";
import "./App.css";
import HeaderComponent from "./components/HeaderComponent/HeaderComponent";
import ToDoComponent from "./components/ToDoContainer/ToDoComponent";

function App() {
    const [searchString, setSearchString] = useState<string>("");

    return (
        <>
            <HeaderComponent
                setSearchString={setSearchString}
            ></HeaderComponent>
            <ToDoComponent searchString={searchString}></ToDoComponent>
        </>
    );
}

export default App;
