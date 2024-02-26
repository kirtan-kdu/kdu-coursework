import { PayloadAction, createSlice } from "@reduxjs/toolkit";

interface TodoList {
    todoList: string[];
}

const initialState: TodoList = {
    todoList: [],
};

const TodoListSlice = createSlice({
    name: "TodoList",
    initialState,
    reducers: {
        addTodo: (state, action: PayloadAction<string>) => {
            state.todoList.push(action.payload);
        },
        removeTodo: (state, action: PayloadAction<number>) => {
            state.todoList = state.todoList.filter(
                (_, i) => i !== action.payload
            );
        },
    },
});

export const { addTodo, removeTodo } = TodoListSlice.actions;
export default TodoListSlice.reducer;
