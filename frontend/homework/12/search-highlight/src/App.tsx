import React, { useState } from "react";
import Highlighter from "react-highlight-words";
import "./App.css";

function App() {
    const textToHighlight =
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum";
    const [searchWords, setSearchWords] = useState<string>("");

    const handleOnChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        setSearchWords(event.target.value);
    };

    return (
        <>
            <input
                placeholder='input text here...'
                type='text'
                value={searchWords}
                onChange={(event) => handleOnChange(event)}
            />
            <p>
                <Highlighter
                    highlightClassName='YourHighlightClass'
                    searchWords={[searchWords]}
                    autoEscape={true}
                    textToHighlight={textToHighlight}
                />
            </p>
        </>
    );
}

export default App;
