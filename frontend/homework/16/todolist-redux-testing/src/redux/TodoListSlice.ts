import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import { persistReducer } from "redux-persist";
import storageSession from "redux-persist/lib/storage/session";

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

const persistConfig = {
    key: "todoList",
    storage: storageSession,
};

export const persistedTodoListReducer = persistReducer(
    persistConfig,
    TodoListSlice.reducer
);

export const { addTodo, removeTodo } = TodoListSlice.actions;
