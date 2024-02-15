"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var server_1 = require("./server");
var mapper_1 = require("./mapper");
var repository_1 = require("./repository");
// DOM Events
var searchBar = document.querySelector("#recipe-input");
var searchButton = document.querySelector(".search-icon");
var recipeSection = document.querySelector(".recipe-items");
window.onload = function () {
    console.log("Window is loaded!");
    if (recipeSection !== null && repository_1.recipesList.length > 0) {
        repository_1.recipesList.forEach(function (recipe) {
            recipeSection.appendChild(createCard(recipe));
        });
    }
};
searchButton === null || searchButton === void 0 ? void 0 : searchButton.addEventListener("click", function (event) {
    console.log("clicked");
    var recipeName = "";
    if (searchBar && typeof searchBar.value === "string") {
        recipeName = searchBar === null || searchBar === void 0 ? void 0 : searchBar.value;
    }
    console.log(recipeName);
});
(0, server_1.fetchRecipes)()
    .then(function (responseData) {
    return (0, mapper_1.mapApiResponseToRecipeList)(responseData);
})
    .then(function (recipeList) { return (0, repository_1.setRecipes)(recipeList); });
function createCard(recipe) {
    var card = document.createElement("div");
    card.className = "recipe-card";
    card.innerHTML = "\n        <img src=\"".concat(recipe.imageUrl, "\" alt=\"").concat(recipe.name, "\">\n        <h2>").concat(recipe.name, "</h2>\n        <ul class=\"recipe-details\">\n            <li><strong>Ingredients:</strong> ").concat(recipe.ingredients.join(", "), "</li>\n            <li><strong>Cuisine:</strong> ").concat(recipe.cuisine, "</li>\n            <li><strong>Difficulty:</strong> ").concat(recipe.difficulty, "</li>\n            <li><strong>Time:</strong> ").concat(recipe.totalTime, "</li>\n            <li><strong>Calories:</strong> ").concat(recipe.calories, "</li>\n        </ul>\n    ");
    return card;
}
