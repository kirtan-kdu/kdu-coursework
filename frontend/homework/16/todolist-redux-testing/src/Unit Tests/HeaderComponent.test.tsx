// Header.test.tsx
import { beforeEach, describe, expect, test } from "vitest";
import { render, fireEvent, screen } from "@testing-library/react";

import HeaderComponent from "../components/HeaderComponent/HeaderComponent";
import { Provider } from "react-redux";
import { persistedStore, store } from "../redux/Stores";
import { PersistGate } from "redux-persist/integration/react";

describe("Header component", () => {
    beforeEach(() => {
        render(
            <Provider store={store}>
                <PersistGate loading={null} persistor={persistedStore}>
                    <HeaderComponent />
                </PersistGate>
            </Provider>
        );
    });
    test("renders title and search bar", () => {
        expect(screen.getByText("Item Lister")).toBeTruthy();
        expect(screen.getByRole("textbox")).toBeTruthy();
    });

    test("search bar updates value on change", () => {
        const searchInput = screen.getByRole("textbox");
        fireEvent.change(searchInput, { target: { value: "Test Search" } });
        expect(searchInput).toHaveProperty("value", "Test Search");
    });
});
