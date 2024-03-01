import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import { getStockListThunk } from "../thunks/DashboardTableThunk";

export interface IStock {
    stock_name: string;
    stock_symbol: string;
    base_price: number;
}

interface IDashboardTable {
    stockList: IStock[];
    state: "fulfilled" | "error" | "pending";
}

const initialState: IDashboardTable = {
    stockList: [],
    state: "fulfilled",
};

const DashboardTableSlice = createSlice({
    name: "DashboardTableSlice",
    initialState,
    reducers: {},
    extraReducers(builder) {
        builder
            .addCase(
                getStockListThunk.fulfilled,
                (state, action: PayloadAction<IStock[]>) => {
                    state.stockList = action.payload;
                    state.state = "fulfilled";
                }
            )
            .addCase(getStockListThunk.pending, (state) => {
                state.stockList = [];
                state.state = "pending";
                console.log("Pending state");
            })
            .addCase(getStockListThunk.rejected, (state) => {
                state.stockList = [];
                state.state = "error";
                console.log("Failed to fetch stocklist");
            });
    },
});

export const DashboardTableReducer = DashboardTableSlice.reducer;
