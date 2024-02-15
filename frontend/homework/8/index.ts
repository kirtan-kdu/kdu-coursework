import { IRecipeItem, fetchRecipes, IRecipeResponse } from "./server";
import { mapApiResponseToRecipeList } from "./mapper";
import { recipesList, setRecipes } from "./repository";

// DOM Events
const searchBar: HTMLInputElement | null =
    document.querySelector("#recipe-input");
const searchButton: HTMLElement | null = document.querySelector(".search-icon");
const recipeSection: HTMLElement | null =
    document.querySelector(".recipe-items");

window.onload = () => {
    console.log("Window is loaded!");
    if (recipeSection !== null && recipesList.length > 0) {
        recipesList.forEach((recipe: IRecipeItem) => {
            recipeSection.appendChild(createCard(recipe));
        });
    }
};

searchButton?.addEventListener("click", (event: MouseEvent) => {
    console.log("clicked");
    let recipeName: string = "";
    if (searchBar && typeof searchBar.value === "string") {
        recipeName = searchBar?.value;
    }
    console.log(recipeName);
});

fetchRecipes()
    .then((responseData: IRecipeResponse) =>
        mapApiResponseToRecipeList(responseData)
    )
    .then((recipeList) => setRecipes(recipeList));

function createCard(recipe: IRecipeItem): HTMLElement {
    const card = document.createElement("div");
    card.className = "recipe-card";
    card.innerHTML = `
        <img src="${recipe.imageUrl}" alt="${recipe.name}">
        <h2>${recipe.name}</h2>
        <ul class="recipe-details">
            <li><strong>Ingredients:</strong> ${recipe.ingredients.join(
                ", "
            )}</li>
            <li><strong>Cuisine:</strong> ${recipe.cuisine}</li>
            <li><strong>Difficulty:</strong> ${recipe.difficulty}</li>
            <li><strong>Time:</strong> ${recipe.totalTime}</li>
            <li><strong>Calories:</strong> ${recipe.calories}</li>
        </ul>
    `;
    return card;
}
