import { createAsyncThunk } from "@reduxjs/toolkit";
import { ITransaction } from "../slices/TransactionListSlice";

export const getTransactionListThunk = createAsyncThunk<ITransaction[]>(
    "getTransactionListThunk",
    async () => {
        return fetch("http://localhost:5000/get/transactions").then(
            (response) => {
                if (!response.ok) {
                    throw new Error("Network response was not ok");
                }
                return response.json();
            }
        );
    }
);
