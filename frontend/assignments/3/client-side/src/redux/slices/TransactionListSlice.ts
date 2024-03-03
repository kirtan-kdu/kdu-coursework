import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import { getTransactionListThunk } from "../thunks/TransactionListThunk";

export interface ITransaction {
    stock_name: string;
    stock_symbol: string;
    transaction_price: number;
    timestamp: string;
    status: "Passed" | "Failed";
}

export interface GroupByDateTransaction {
    date: string;
    transactions: ITransaction[];
}

interface GroupByDateTransactionList {
    groupByDateList: GroupByDateTransaction[];
}

const initialState: GroupByDateTransactionList = {
    groupByDateList: [
        {
            date: "",
            transactions: [],
        },
    ],
};

const TransactionListSlice = createSlice({
    name: "TransactionList",
    initialState,
    reducers: {},
    extraReducers(builder) {
        builder
            .addCase(
                getTransactionListThunk.fulfilled,
                (state, action: PayloadAction<ITransaction[]>) => {
                    state.groupByDateList = [];

                    // Group transactions by date
                    const groupedTransactions: {
                        [key: string]: ITransaction[];
                    } = {};
                    action.payload.forEach((transaction) => {
                        const date = transaction.timestamp.split("T")[0]; // Extract the date part
                        if (!groupedTransactions[date]) {
                            groupedTransactions[date] = [];
                        }
                        groupedTransactions[date].push(transaction);
                    });

                    // Convert the groupedTransactions object to the desired structure
                    state.groupByDateList = Object.entries(
                        groupedTransactions
                    ).map(([date, transactions]) => ({
                        date,
                        transactions,
                    }));
                }
            )
            .addCase(getTransactionListThunk.pending, (state) => {
                state.groupByDateList = [];
            })
            .addCase(getTransactionListThunk.rejected, (state) => {
                state.groupByDateList = [];
            });
    },
});

export const TransactionListReducer = TransactionListSlice.reducer;
