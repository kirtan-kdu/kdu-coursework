import { PayloadAction, createSlice } from "@reduxjs/toolkit";

interface CounterType {
    count: number;
    inputNumber: number;
}
const initialState: CounterType = {
    count: 0,
    inputNumber: 0,
};

const counterSlice = createSlice({
    name: "counter",
    initialState,
    reducers: {
        increment: (state) => {
            state.count += 1;
        },
        decrement: (state) => {
            state.count -= 1;
        },
        incrementBy: (state, action: PayloadAction<number>) => {
            state.count += action.payload;
        },
        decrementBy: (state, action: PayloadAction<number>) => {
            state.count -= action.payload;
        },
        changeInputNumber: (state, action: PayloadAction<number>) => {
            state.inputNumber = action.payload;
        },
    },
});

export const {
    increment,
    decrement,
    incrementBy,
    decrementBy,
    changeInputNumber,
} = counterSlice.actions;
export default counterSlice.reducer;
