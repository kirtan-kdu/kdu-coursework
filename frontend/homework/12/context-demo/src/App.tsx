import React from "react";
import "./App.css";
import { ThemeProvider } from "./ThemeContext";
import Wrapper from "./Wrapper";

function App() {
    return (
        <ThemeProvider>
            <Wrapper />
        </ThemeProvider>
    );
}

export default App;
