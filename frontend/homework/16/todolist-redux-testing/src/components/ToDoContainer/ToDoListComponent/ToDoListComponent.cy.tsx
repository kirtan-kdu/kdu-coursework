import { Provider } from "react-redux";
import ToDoListComponent from "./ToDoListComponent";
import { store } from "../../../redux/Stores";

describe("<ToDoListComponent />", () => {
    it("renders", () => {
        cy.viewport(1076, 876);
        cy.mount(
            <Provider store={store}>
                <ToDoListComponent />
            </Provider>
        );

        cy.get(".no-todo-container")
            .should("exist")
            .and("be.visible")
            .should("have.text", "You are free 🥳");
    });
});
