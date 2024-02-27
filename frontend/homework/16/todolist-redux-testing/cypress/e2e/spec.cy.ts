describe("template spec", () => {
    it("passes", () => {
        cy.viewport(1076, 876);
        cy.visit("http://localhost:5173");
    });

    beforeEach(() => {
        cy.visit("http://localhost:5173");
    });

    const addItemToList = (itemName: string) => {
        cy.get("#todo-input").type(itemName);
        cy.get(".add-todo-btn").click();
    };

    it("renders the home page", () => {
        cy.get(".todolist-container").should("exist").and("be.visible");
        cy.get(".no-todo-tag").should("have.text", "You are free 🥳");
    });

    it("add todos to the list", () => {
        addItemToList("Todo task 1");
        addItemToList("Todo task 2");
    });

    it("remove items from list", () => {
        addItemToList("Todo task 1");
        cy.get("#delete-todo").click();
        cy.get(".no-todo-tag").should("have.text", "You are free 🥳");
    });

    it("search available items", () => {
        addItemToList("Item 1");
        addItemToList("Item 2");
        cy.get(".search-input").type("Item 1");
        cy.get(".todo-list-wrapper").contains("Item 1");
    });

    it("search unavailable items", () => {
        addItemToList("Item 1");
        addItemToList("Item 2");
        cy.get(".search-input").type("Item 3");
        cy.get(".no-todo-tag").should("have.text", "No match found!");
    });
});
