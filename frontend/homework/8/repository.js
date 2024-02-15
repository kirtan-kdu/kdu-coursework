"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.setRecipes = exports.recipesList = void 0;
exports.recipesList = [];
function setRecipes(newRecipes) {
    exports.recipesList.length = 0; // Clear the array
    exports.recipesList.push.apply(// Clear the array
    exports.recipesList, newRecipes); // Push new items into the array
}
exports.setRecipes = setRecipes;
