import { createAsyncThunk } from "@reduxjs/toolkit";
import { IProduct } from "../../types/Product.type";

export const getProductListThunk = createAsyncThunk<IProduct[]>(
    "getProductList",
    async () => {
        return fetch("https://fakestoreapi.com/producs").then((response) => {
            if (!response.ok) {
                throw new Error("Network response was not ok");
            }
            return response.json();
        });
    }
);
