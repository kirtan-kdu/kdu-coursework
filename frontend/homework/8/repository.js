"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.setRecipes = exports.recipesList = void 0;
exports.recipesList = [];
function setRecipes(newRecipes) {
    exports.recipesList.length = 0;
    exports.recipesList.push.apply(exports.recipesList, newRecipes);
}
exports.setRecipes = setRecipes;
