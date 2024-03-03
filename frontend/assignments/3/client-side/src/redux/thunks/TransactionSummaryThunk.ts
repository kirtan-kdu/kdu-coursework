import { createAsyncThunk } from "@reduxjs/toolkit";
import { ITransactionSummary } from "../slices/SummarizerSlice";

export const getTransactionSummaryThunk = createAsyncThunk<
    ITransactionSummary[]
>("getTransactionSummaryThunk", async () => {
    return fetch("http://localhost:5000/get/transactions/all").then(
        (response) => {
            if (!response.ok) {
                throw new Error("Network response was not ok");
            }
            return response.json();
        }
    );
});
