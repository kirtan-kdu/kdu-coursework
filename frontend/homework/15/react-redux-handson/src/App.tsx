import { useDispatch, useSelector } from "react-redux";
import "./App.css";
import { RootState } from "./redux/Stores";
import {
    changeInputNumber,
    decrementBy,
    incrementBy,
} from "./redux/CounterSlice";

function App() {
    function onIncrementChangeHandler(): void {
        reduxDispatch(incrementBy(inputNumber));
    }

    function onDecrementChangeHandler(): void {
        reduxDispatch(decrementBy(inputNumber));
    }

    const count: number = useSelector(
        (state: RootState) => state.counter.count
    );

    const inputNumber: number = useSelector(
        (state: RootState) => state.counter.inputNumber
    );

    const reduxDispatch = useDispatch();
    return (
        <>
            <input
                type='number'
                placeholder='Enter number'
                value={inputNumber}
                onChange={(event) => {
                    reduxDispatch(
                        changeInputNumber(event.target.valueAsNumber)
                    );
                }}
            />
            <button onClick={onDecrementChangeHandler} className='dec-btn'>
                Decrement By
            </button>
            <h1>{count}</h1>
            <button onClick={onIncrementChangeHandler} className='inc-btn'>
                Increment By
            </button>
        </>
    );
}

export default App;
