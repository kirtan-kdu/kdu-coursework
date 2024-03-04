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

export interface GroupByDateTransactionList {
    groupByDateList: GroupByDateTransaction[];
    state: "loaded" | "not loaded";
}

const initialState: GroupByDateTransactionList = {
    groupByDateList: [
        {
            date: "",
            transactions: [],
        },
    ],
    state: "not loaded",
};

const TransactionListSlice = createSlice({
    name: "TransactionList",
    initialState,
    reducers: {
        addTransaction: (state, action: PayloadAction<ITransaction>) => {
            const newTransaction = action.payload;
            const newDate = newTransaction.timestamp.split("T")[0];
            const existingGroup = state.groupByDateList.find(
                (group) => group.date === newDate
            );
            if (existingGroup) {
                state.groupByDateList = state.groupByDateList.map((group) =>
                    group.date === newDate
                        ? {
                              ...group,
                              transactions: [
                                  newTransaction,
                                  ...group.transactions,
                              ],
                          }
                        : group
                );
            } else {
                state.groupByDateList = [
                    { date: newDate, transactions: [newTransaction] },
                    ...state.groupByDateList,
                ];
            }
        },
    },
    extraReducers(builder) {
        builder
            .addCase(
                getTransactionListThunk.fulfilled,
                (state, action: PayloadAction<ITransaction[]>) => {
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
                    state.groupByDateList = [
                        ...state.groupByDateList,
                        ...Object.entries(groupedTransactions).map(
                            ([date, transactions]) => ({
                                date,
                                transactions,
                            })
                        ),
                    ];

                    state.state = "loaded";
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

export const { addTransaction } = TransactionListSlice.actions;
export const TransactionListReducer = TransactionListSlice.reducer;
