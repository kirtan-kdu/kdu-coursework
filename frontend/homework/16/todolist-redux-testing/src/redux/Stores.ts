import { configureStore } from "@reduxjs/toolkit";
import { persistedTodoListReducer } from "./TodoListSlice";
import SearchInputSlice from "./SearchInputSlice";
import persistStore from "redux-persist/es/persistStore";

export const store = configureStore({
    reducer: {
        TodoList: persistedTodoListReducer,
        SearchInput: SearchInputSlice,
    },
});

export const persistedStore = persistStore(store);

export type RootState = ReturnType<typeof store.getState>;
