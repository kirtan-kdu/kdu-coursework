import { PayloadAction, createSlice } from "@reduxjs/toolkit";

interface SearchInput {
    searchInput: string;
}

const initialState: SearchInput = {
    searchInput: "",
};

const SearchInputSlice = createSlice({
    name: "SearchInput",
    initialState,
    reducers: {
        changeInput: (state, action: PayloadAction<string>) => {
            state.searchInput = action.payload;
        },
    },
});

export const { changeInput } = SearchInputSlice.actions;
export default SearchInputSlice.reducer;
