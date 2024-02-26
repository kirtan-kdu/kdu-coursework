import { useRef } from "react";

// Ensuring mutable values are persisted across multiple renders.
const Task1 = () => {
    const count = useRef(0);

    const handleChange = () => {
        count.current += 1;
        console.log(count);
    };

    return (
        <div>
            <h1>Count value: {count.current}</h1>
            <button onClick={handleChange}>
                <h2>+</h2>
            </button>
        </div>
    );
};

export default Task1;
