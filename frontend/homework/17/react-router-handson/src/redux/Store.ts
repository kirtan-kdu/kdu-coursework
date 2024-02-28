import { configureStore } from "@reduxjs/toolkit";
import { ProductPersistReducer } from "./ProductListSlice";
import persistStore from "redux-persist/es/persistStore";
import { FilterParamsPersistReducer } from "./FilterParamsSlice";

export const productListStore = configureStore({
    reducer: {
        productListReducer: ProductPersistReducer,
        filterParamsReducer: FilterParamsPersistReducer,
    },
});

export const ProductListPersistStore = persistStore(productListStore);

export type RootState = ReturnType<typeof productListStore.getState>;
export type DispatchType = typeof productListStore.dispatch;
