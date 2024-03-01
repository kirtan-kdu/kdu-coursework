import { configureStore } from "@reduxjs/toolkit";
import { DashboardTableReducer } from "./slices/DashboardTableSlice";

export const StockMarketStore = configureStore({
    reducer: {
        productListReducer: DashboardTableReducer,
    },
});

export type RootState = ReturnType<typeof StockMarketStore.getState>;
export type DispatchType = typeof StockMarketStore.dispatch;
