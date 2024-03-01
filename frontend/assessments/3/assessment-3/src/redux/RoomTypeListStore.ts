import { configureStore } from "@reduxjs/toolkit";
import { RoomTypeListReducer } from "./Slice/RoomTypeListSlice";
import { persistStore } from "redux-persist";
import { CurrentRoomDetailReducer } from "./Slice/CurrentRoomDetails";

export const roomTypeListStore = configureStore({
    reducer: {
        productListReducer: RoomTypeListReducer,
        currRoomDetailReducer: CurrentRoomDetailReducer,
    },
});

// export const roomTypeListPersistStore = persistStore(roomTypeListStore);

export type RootState = ReturnType<typeof roomTypeListStore.getState>;
export type DispatchType = typeof roomTypeListStore.dispatch;
