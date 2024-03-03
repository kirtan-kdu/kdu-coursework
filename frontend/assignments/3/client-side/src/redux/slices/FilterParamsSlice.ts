import { PayloadAction, createSlice } from "@reduxjs/toolkit";

type Status = "all" | "Passed" | "Failed";

interface FilterParams {
    searchString: string;
    startDate: string;
    endDate: string;
    status: Status;
    companyFilter: string[];
}

const initialState: FilterParams = {
    searchString: "",
    startDate: "",
    endDate: "",
    status: "all",
    companyFilter: [],
};

const FilterParamsSlice = createSlice({
    name: "FilterParams",
    initialState,
    reducers: {
        setSearchString: (state, action: PayloadAction<string>) => {
            state.searchString = action.payload;
        },
        setStartDate: (state, action: PayloadAction<string>) => {
            state.startDate = action.payload;
        },
        setEndDate: (state, action: PayloadAction<string>) => {
            state.endDate = action.payload;
        },
        addStatus: (state, action: PayloadAction<Status>) => {
            const currStatus = action.payload;
            if (state.status === "all") {
                state.status = currStatus;
            } else state.status = "all";
        },
        removeStatus: (state, action: PayloadAction<Status>) => {
            const currStatus = action.payload;
            if (state.status === "all") {
                state.status = currStatus === "Passed" ? "Failed" : "Passed";
            } else state.status = "all";
        },
        addCompanyFilter: (state, action: PayloadAction<string>) => {
            state.companyFilter.push(action.payload);
        },
        removeCompanyFilter: (state, action: PayloadAction<string>) => {
            state.companyFilter.splice(
                state.companyFilter.indexOf(action.payload),
                1
            );
        },
        clearAll: (state) => {
            state.companyFilter = [];
            state.searchString = "";
            state.startDate = "";
            state.endDate = "";
            state.status = "all";
        },
    },
});

export const FilterParamsReducer = FilterParamsSlice.reducer;
export const {
    setEndDate,
    setSearchString,
    addCompanyFilter,
    addStatus,
    setStartDate,
    removeCompanyFilter,
    removeStatus,
    clearAll,
} = FilterParamsSlice.actions;
