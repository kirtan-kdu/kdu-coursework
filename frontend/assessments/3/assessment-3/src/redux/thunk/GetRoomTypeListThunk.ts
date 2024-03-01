import { createAsyncThunk } from "@reduxjs/toolkit";
import { IRoomTypeListResponse } from "../Slice/RoomTypeListSlice";

export const getRoomTypeListThunk = createAsyncThunk<IRoomTypeListResponse>(
    "getRoomTypeList",
    async () => {
        return fetch(
            "https://kdu-automation.s3.ap-south-1.amazonaws.com/mini-project-apis/assessment-3.json"
        ).then((response) => {
            if (!response.ok) {
                throw new Error("Network response was not ok");
            }
            return response.json();
        });
    }
);
