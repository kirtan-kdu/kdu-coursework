import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import { getUniqueCompaniesThunk } from "../thunks/UniqueCompaniesThunk";

interface IUniqueCompanies {
    uniqueCompanies: string[];
}

const initialState: IUniqueCompanies = {
    uniqueCompanies: [],
};

const UniqueCompaniesSlice = createSlice({
    name: "UniqueCompanies",
    initialState,
    reducers: {},
    extraReducers(builder) {
        builder.addCase(getUniqueCompaniesThunk.fulfilled, (state, action: PayloadAction<string[]>) => {
            state.uniqueCompanies = action.payload;
        });
    },
});

export const UniqueCompaniesReducer = UniqueCompaniesSlice.reducer;
