import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import persistReducer from "redux-persist/es/persistReducer";
import storageSession from "redux-persist/lib/storage/session";

interface IFilterParams {
    searchString: string;
    categoryFilter: string;
    sortBy: string;
}

const initialState: IFilterParams = {
    searchString: "",
    categoryFilter: "",
    sortBy: "",
};

const FilterParamsSlice = createSlice({
    name: "FilterParams",
    initialState,
    reducers: {
        setCategoryFilter: (state, action: PayloadAction<string>) => {
            state.categoryFilter = action.payload;
        },
        setSearchString: (state, action: PayloadAction<string>) => {
            state.searchString = action.payload;
        },
        setSortBy: (state, action: PayloadAction<string>) => {
            state.sortBy = action.payload;
        },
    },
});

const persistConfig = {
    key: "FilterParams",
    storage: storageSession,
};

export const FilterParamsPersistReducer = persistReducer(
    persistConfig,
    FilterParamsSlice.reducer
);

export const { setSearchString, setCategoryFilter, setSortBy } =
    FilterParamsSlice.actions;
