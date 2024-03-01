import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import { getRoomTypeListThunk } from "../thunk/GetRoomTypeListThunk";
import storageSession from "redux-persist/lib/storage/session";
import { persistReducer } from "redux-persist";

interface AddOn {
    name: string;
    cost: number;
    currency: string;
}

export interface IRoomType {
    id: number;
    name: string;
    costPerNight: number;
    currency: string;
    addOns: AddOn[];
}

export interface IRoomTypeList {
    roomTypeList: IRoomType[];
}

export interface IRoomTypeListResponse {
    roomTypes: IRoomTypeList;
}

const initialState: IRoomTypeListResponse = {
    roomTypes: {
        roomTypeList: [],
    },
};

const RoomTypeListSlice = createSlice({
    name: "RoomTypeList",
    initialState,
    reducers: {},
    extraReducers(builder) {
        builder.addCase(
            getRoomTypeListThunk.fulfilled,
            (state, action: PayloadAction<IRoomTypeListResponse>) => {
                state.roomTypes.roomTypeList = action.payload.roomTypes;
            }
        );
    },
});

const persistConfig = {
    key: "roomTypeList",
    storage: storageSession,
};

export const RoomTypeListReducer = persistReducer(
    persistConfig,
    RoomTypeListSlice.reducer
);
