import { PayloadAction, createSlice } from "@reduxjs/toolkit";

export interface RoomDetails {
    roomId: number;
    startDate: string;
    endDate: string;
    preferences: string[];
    price: number;
}

const initialState: RoomDetails = {
    roomId: 0,
    startDate: "",
    endDate: "",
    preferences: [],
    price: 0,
};

const CurrentRoomDetailSlice = createSlice({
    name: "CurrentRoomSlice",
    initialState,
    reducers: {
        setStartDate: (state, action: PayloadAction<string>) => {
            state.startDate = action.payload;
        },
        setEndDate: (state, action: PayloadAction<string>) => {
            state.endDate = action.payload;
            console.log(state.endDate, "enddate is set to ");
        },
        setRoomId: (state, action: PayloadAction<number>) => {
            state.roomId = action.payload;
        },
        addAddons: (state, action: PayloadAction<string>) => {
            if (state.preferences.find((addon) => addon === action.payload))
                state.preferences.splice(
                    state.preferences.indexOf(action.payload)
                );
            else {
                state.preferences.push(action.payload);
            }
        },
    },
});

export const { setStartDate, setEndDate, setRoomId, addAddons } =
    CurrentRoomDetailSlice.actions;
export const CurrentRoomDetailReducer = CurrentRoomDetailSlice.reducer;
