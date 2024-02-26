import { useEffect, useRef } from "react";

// Use the useRef hook to focus on the first input field on a form page.
const Task2 = () => {
    const inputRef = useRef<HTMLInputElement>(null);

    useEffect(() => {
        if (inputRef.current) {
            inputRef.current.focus();
        }
    }, []);

    return (
        <div>
            <form method='get'>
                <label htmlFor='fname'>First name:</label>
                <input ref={inputRef} type='text' id='fname' name='fname' />
                <label htmlFor='lname'>Last name:</label>
                <input type='text' id='lname' name='lname' />
                <input type='submit' value='Submit' />
            </form>
        </div>
    );
};

export default Task2;
