"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.searchRecipes = exports.fetchRecipes = void 0;
var mapper_1 = require("./mapper");
var fetchRecipes = function () {
    return fetch("https://dummyjson.com/recipes")
        .then(function (response) {
        if (!response.ok) {
            throw new Error("HTTP error! status: ".concat(response.status));
        }
        return response.json();
    })
        .catch(function (error) {
        console.error("There has been a problem with your fetch operation: ", error);
    });
};
exports.fetchRecipes = fetchRecipes;
var searchRecipes = function (recipeName) {
    return fetch("https://dummyjson.com/recipes/search?q=".concat(recipeName))
        .then(function (response) {
        if (!response.ok) {
            throw new Error("HTTP error from external API! status: ".concat(response.status));
        }
        return response.json();
    })
        .catch(function (error) {
        console.error("There has been a problem with your fetch operation: ", error);
    });
};
exports.searchRecipes = searchRecipes;
(0, exports.searchRecipes)("margherita")
    .then(function (responseData) {
    return (0, mapper_1.mapApiResponseToRecipeList)(responseData);
})
    .then(function (recipe) { return console.log(recipe); });
