import { createAsyncThunk } from "@reduxjs/toolkit";
import { IStock } from "../slices/DashboardTableSlice";

export const getStockListThunk = createAsyncThunk<IStock[]>(
    "getStockListThunk",
    async () => {
        return fetch("http://localhost:5000/get/stocks").then((response) => {
            if (!response.ok) {
                throw new Error("Network response was not ok");
            }
            return response.json();
        });
    }
);
