// Header.test.tsx
import { beforeEach, describe, expect, test } from "vitest";
import { render, fireEvent, screen } from "@testing-library/react";

import { Provider } from "react-redux";
import { store } from "../redux/Stores";
import AddToDoComponent from "../components/ToDoContainer/AddToDoComponent/AddToDoComponent";

describe("Header component", () => {
    beforeEach(() => {
        render(
            <Provider store={store}>
                <AddToDoComponent />
            </Provider>
        );
    });
    test("renders title and input box and add button", () => {
        expect(screen.getByText("Add Items")).toBeTruthy();
        expect(screen.getByRole("textbox")).toBeTruthy();
    });

    test("input box updates value on change", () => {
        const inputBox = screen.getByRole("textbox");
        fireEvent.change(inputBox, { target: { value: "Test Search" } });
        expect(inputBox).toHaveProperty("value", "Test Search");
    });

    test("add button should be disabled ", () => {
        const addBtn = screen.getByRole("button");
        expect(addBtn.innerHTML).toMatch("Add");
        expect(addBtn).toHaveProperty("disabled", true);
    });

    test("add button should get enabled after giving input", () => {
        const addBtn = screen.getByRole("button");
        const inputBox = screen.getByRole("textbox");
        expect(addBtn).toHaveProperty("disabled", true);
        fireEvent.change(inputBox, { target: { value: "Test Search" } });
        expect(addBtn).toHaveProperty("disabled", false);
    });
});
