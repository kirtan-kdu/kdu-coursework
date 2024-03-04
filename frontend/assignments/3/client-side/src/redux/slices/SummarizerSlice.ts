import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import { getTransactionSummaryThunk } from "../thunks/TransactionSummaryThunk";

export interface ITransactionData {
    date: string;
    prices: number[];
}

export interface ITransactionSummary {
    company: string;
    symbol: string;
    data: ITransactionData[];
}

export interface IProfitSummary {
    company: string;
    symbol: string;
    maxProfit: number;
    buyDay: string;
    sellDay: string;
    buyAmount: number;
    sellAmount: number;
}

interface ITransactionSummaryList {
    transactionSummary: ITransactionSummary[];
    profitSummary: IProfitSummary[];
}

const initialState: ITransactionSummaryList = {
    transactionSummary: [],
    profitSummary: [],
};

const TransactionSummarySlice = createSlice({
    name: "TransactionSummarySlice",
    initialState,
    reducers: {
        setProfitSummary: (state, action: PayloadAction<IProfitSummary[]>) => {
            state.profitSummary = action.payload;
        },
    },
    extraReducers(builder) {
        builder.addCase(
            getTransactionSummaryThunk.fulfilled,
            (state, action: PayloadAction<ITransactionSummary[]>) => {
                state.transactionSummary = action.payload;
            }
        );
    },
});

export const { setProfitSummary } = TransactionSummarySlice.actions;
export const TransactionSummaryReducer = TransactionSummarySlice.reducer;
