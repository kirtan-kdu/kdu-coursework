import { useRef, useState } from "react";

// Create a simple component to implement a Timer Application.
const Task3 = () => {
    const timerValue = useRef<number | null>(null);
    const [seconds, setSeconds] = useState(0);

    const startTimer = () => {
        timerValue.current = setInterval(() => {
            setSeconds((prevSeconds) => prevSeconds + 1);
        }, 1000);
    };

    const stopTimer = () => {
        clearInterval(timerValue.current!);
        setSeconds(0);
    };

    const pauseTimer = () => {
        if (timerValue.current !== null) {
            clearInterval(timerValue.current);
        }
    };

    return (
        <div>
            <h2>Timer: {seconds} seconds</h2>
            <button onClick={startTimer}>Start</button>
            <button onClick={pauseTimer}>Pause</button>
            <button onClick={stopTimer}>Restart</button>
        </div>
    );
};

export default Task3;
