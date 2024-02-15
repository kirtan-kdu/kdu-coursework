"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.mapApiResponseToRecipeList = void 0;
function mapApiResponseToRecipeList(responseData) {
    return responseData.recipes.map(function (recipeData) { return ({
        imageUrl: recipeData.image,
        name: recipeData.name,
        rating: recipeData.rating,
        cuisine: recipeData.cuisine,
        ingredients: recipeData.ingredients,
        difficulty: recipeData.difficulty,
        totalTime: recipeData.prepTimeMinutes + recipeData.cookTimeMinutes,
        calories: recipeData.caloriesPerServing * recipeData.servings,
    }); });
}
exports.mapApiResponseToRecipeList = mapApiResponseToRecipeList;
