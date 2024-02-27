import HeaderComponent from "./HeaderComponent";
import { Provider } from "react-redux";
import { store } from "../../redux/Stores";

describe("<HeaderComponent />", () => {
    it("renders", () => {
        cy.viewport(1076, 876);

        cy.mount(
            <Provider store={store}>
                <HeaderComponent />
            </Provider>
        );
        cy.get(".heading-tag")
            .should("exist")
            .and("be.visible")
            .should("have.text", "Item Lister");

        cy.get(".search-input")
            .should("exist")
            .and("be.visible")
            .and("have.text", "");

        cy.get(".search-input")
            .type("Test search")
            .wait(4000)
            .and("have.value", "Test search");
    });
});
