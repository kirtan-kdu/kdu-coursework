import React, {
    Dispatch,
    SetStateAction,
    createContext,
    useMemo,
    useState,
} from "react";

interface IToDoList {
    todoList: string[];
    setTodoList: Dispatch<SetStateAction<string[]>>;
}

const defaultSetSearchInput: Dispatch<SetStateAction<string[]>> = () => {};

export const ToDoListContext = createContext<IToDoList>({
    todoList: [],
    setTodoList: defaultSetSearchInput,
});

interface IToDoListProviderProps {
    children: React.ReactNode;
}

export const TodoListProvider = ({ children }: IToDoListProviderProps) => {
    const [todoList, setTodoList] = useState<string[]>([]);

    const value = useMemo(() => ({ todoList, setTodoList }), [todoList]);

    return (
        <ToDoListContext.Provider value={value}>
            {children}
        </ToDoListContext.Provider>
    );
};
