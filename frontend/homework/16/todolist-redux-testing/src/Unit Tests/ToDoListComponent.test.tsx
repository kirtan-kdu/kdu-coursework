// Header.test.tsx
import { beforeEach, describe, expect, test } from "vitest";
import { render, screen } from "@testing-library/react";

import { Provider } from "react-redux";
import { persistedStore, store } from "../redux/Stores";
import { PersistGate } from "redux-persist/integration/react";
import ToDoListComponent from "../components/ToDoContainer/ToDoListComponent/ToDoListComponent";

describe("Header component", () => {
    beforeEach(() => {
        render(
            <Provider store={store}>
                <PersistGate loading={null} persistor={persistedStore}>
                    <ToDoListComponent />
                </PersistGate>
            </Provider>
        );
    });

    // Can not test todos as add ToDo is different component
    test("renders title and search bar", () => {
        expect(screen.getByText("You are free 🥳")).toBeTruthy();
    });
});
