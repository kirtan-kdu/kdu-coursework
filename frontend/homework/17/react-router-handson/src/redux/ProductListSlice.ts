import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import { IProduct } from "../types/Product.type";
import { persistReducer } from "redux-persist";
import storageSession from "redux-persist/lib/storage/session";
import { getProductListThunk } from "./thunk/ProductListThunk";

export interface IProductWrapper {
    productsList: IProduct[];
    catagoryList: string[];
    state: "fulfilled" | "pending" | "error";
}

const initialState: IProductWrapper = {
    productsList: [],
    catagoryList: [],
    state: "error",
};

const ProductListSlice = createSlice({
    name: "ProductSlice",
    initialState,
    reducers: {},
    extraReducers(builder) {
        builder
            .addCase(
                getProductListThunk.fulfilled,
                (state, action: PayloadAction<IProduct[]>) => {
                    state.catagoryList = Array.from(
                        new Set(
                            action.payload.map(
                                (product: IProduct) => product.category
                            )
                        )
                    );

                    state.productsList = action.payload;
                    state.state = "fulfilled";
                }
            )
            .addCase(getProductListThunk.pending, (state) => {
                state.state = "pending";
            })
            .addCase(getProductListThunk.rejected, (state) => {
                state.state = "error";
            });
    },
});

const persistConfig = {
    key: "productList",
    storage: storageSession,
};

export const ProductPersistReducer = persistReducer(
    persistConfig,
    ProductListSlice.reducer
);
