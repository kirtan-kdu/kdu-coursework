import { configureStore } from "@reduxjs/toolkit";
import { DashboardTableReducer } from "./slices/DashboardListSlice";
import { TransactionListReducer } from "./slices/TransactionListSlice";
import { FilterParamsReducer } from "./slices/FilterParamsSlice";
import { UniqueCompaniesReducer } from "./slices/UniqueCompaniesListSlice";
import { TransactionSummaryReducer } from "./slices/SummarizerSlice";

export const StockMarketStore = configureStore({
    reducer: {
        stockListReducer: DashboardTableReducer,
        transactionListReducer: TransactionListReducer,
        filterParamsReducer: FilterParamsReducer,
        uniqueCompaniesReducer: UniqueCompaniesReducer,
        transactionSummaryReducer: TransactionSummaryReducer,
    },
});

export type RootState = ReturnType<typeof StockMarketStore.getState>;
export type DispatchType = typeof StockMarketStore.dispatch;
