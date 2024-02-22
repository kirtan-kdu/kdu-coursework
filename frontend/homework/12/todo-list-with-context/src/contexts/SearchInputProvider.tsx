import React, {
    Dispatch,
    SetStateAction,
    createContext,
    useMemo,
    useState,
} from "react";

interface ISearchString {
    searchInput: string;
    setSearchInput: Dispatch<SetStateAction<string>>;
}

const defaultSetSearchInput: Dispatch<SetStateAction<string>> = () => {};

export const SearchInputContext = createContext<ISearchString>({
    searchInput: "",
    setSearchInput: defaultSetSearchInput,
});

interface SearchInputProviderProps {
    children: React.ReactNode;
}

export const SearchInputProvider = ({ children }: SearchInputProviderProps) => {
    const [searchInput, setSearchInput] = useState<string>("");

    const value = useMemo(
        () => ({ searchInput, setSearchInput }),
        [searchInput]
    );

    return (
        <SearchInputContext.Provider value={value}>
            {children}
        </SearchInputContext.Provider>
    );
};
