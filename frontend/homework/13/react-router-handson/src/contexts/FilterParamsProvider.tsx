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
    catagoryFilter: string;
    setCatagoryFilter: Dispatch<SetStateAction<string>>;
    sortBy: string;
    setSortBy: Dispatch<SetStateAction<string>>;
}

export const FilterParamsContext = createContext<IFilterParams>({
    searchString: "",
    setSearchString: () => {},
    catagoryFilter: "",
    setCatagoryFilter: () => {},
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
    const [catagoryFilter, setCatagoryFilter] = useState<string>("");
    const [sortBy, setSortBy] = useState<string>("");

    const value = useMemo(
        () => ({
            searchString,
            setSearchString,
            catagoryFilter,
            setCatagoryFilter,
            sortBy,
            setSortBy,
        }),
        [searchString, catagoryFilter, sortBy]
    );

    return (
        <FilterParamsContext.Provider value={value}>
            {children}
        </FilterParamsContext.Provider>
    );
};
