import React from "react";
import AddToDoComponent from "./AddToDoComponent";
import { Provider } from "react-redux";
import { store } from "../../../redux/Stores";

describe("<AddToDoComponent />", () => {
    it("renders", () => {
        cy.viewport(1076, 876);

        cy.mount(
            <Provider store={store}>
                <AddToDoComponent />
            </Provider>
        );

        cy.get(".add-todo-tag")
            .should("exist")
            .and("be.visible")
            .should("have.text", "Add Items");

        cy.get("#todo-input")
            .should("exist")
            .and("be.visible")
            .and("have.text", "");

        cy.get(".add-todo-btn")
            .should("exist")
            .and("be.visible")
            .and("have.text", "Add")
            .and("be.disabled");

        cy.get("#todo-input")
            .type("Its first todo")
            .should("have.value", "Its first todo");

        cy.get(".add-todo-btn").should("not.be.disabled");
    });
});
