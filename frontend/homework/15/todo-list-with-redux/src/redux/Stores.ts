import { configureStore } from "@reduxjs/toolkit";
import TodoListReducer from "./TodoListSlice";
import SearchInputSlice from "./SearchInputSlice";

export const store = configureStore({
    reducer: {
        TodoList: TodoListReducer,
        SearchInput: SearchInputSlice,
    },
});

export type RootState = ReturnType<typeof store.getState>;
