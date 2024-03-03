import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import { getStockListThunk } from "../thunks/DashboardListThunk";

export interface IStock {
    stock_name: string;
    stock_symbol: string;
    base_price: number;
}

interface IDashboardTable {
    stockList: IStock[];
    state: "fulfilled" | "error" | "pending";
    name: string;
}

const prefixes = [
    "Kirtan",
    "Rishav",
    "Sagun",
    "Nitesh",
    "Anupam",
    "Aakash",
    "Farhat",
    "Thanika",
    "Chaitra",
    "Amey",
    "Rohit",
    "Gowrish",
];
const randomName = prefixes[Math.floor(Math.random() * prefixes.length)];

const initialState: IDashboardTable = {
    stockList: [],
    state: "fulfilled",
    name: randomName,
};

const DashboardListSlice = createSlice({
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

export const DashboardTableReducer = DashboardListSlice.reducer;
