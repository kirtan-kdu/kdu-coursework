import React, {
    Dispatch,
    SetStateAction,
    createContext,
    useMemo,
    useState,
} from "react";

interface IFilterParams {
    searchString: string;
    setSearchString: Dispatch<SetStateAction<string>>;
    categoryFilter: string;
    setCategoryFilter: Dispatch<SetStateAction<string>>;
    sortBy: string;
    setSortBy: Dispatch<SetStateAction<string>>;
}

export const FilterParamsContext = createContext<IFilterParams>({
    searchString: "",
    setSearchString: () => {},
    categoryFilter: "",
    setCategoryFilter: () => {},
    sortBy: "",
    setSortBy: () => {},
});

interface IFilterParamsProviderProps {
    children: React.ReactNode;
}

export const FilterParamsProvider = ({
    children,
}: IFilterParamsProviderProps) => {
    const [searchString, setSearchString] = useState<string>("");
    const [categoryFilter, setCategoryFilter] = useState<string>("");
    const [sortBy, setSortBy] = useState<string>("");

    const value = useMemo(
        () => ({
            searchString,
            setSearchString,
            categoryFilter,
            setCategoryFilter,
            sortBy,
            setSortBy,
        }),
        [searchString, categoryFilter, sortBy]
    );

    return (
        <FilterParamsContext.Provider value={value}>
            {children}
        </FilterParamsContext.Provider>
    );
};
