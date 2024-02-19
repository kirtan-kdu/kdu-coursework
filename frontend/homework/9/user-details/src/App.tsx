import React from "react";
import "./App.css";
import UserContainer from "./components/UserContainer";

function App() {
    const user = {
        name: "Amey",
        fullName: "Amey Aditya",
        qualification: "SSE",
        skills: [
            {
                id: 1,
                skill: "Python",
            },
            {
                id: 2,
                skill: "React",
            },
        ],
        hobbies: [
            {
                id: 1,
                hobby: "Cricket",
            },
        ],
    };
    return <UserContainer userDetails={user} />;
}

export default App;
