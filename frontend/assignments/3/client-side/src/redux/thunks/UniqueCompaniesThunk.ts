import { createAsyncThunk } from "@reduxjs/toolkit";

export const getUniqueCompaniesThunk = createAsyncThunk<string[]>(
    "getUniqueCompaniesThunk",
    async () => {
        return fetch("http://localhost:5000/get/unique/companies").then(
            (response) => {
                if (!response.ok) {
                    throw new Error("Network response was not ok");
                }
                return response.json();
            }
        );
    }
);
