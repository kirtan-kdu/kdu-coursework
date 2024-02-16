import { IRecipeItem, IRecipeResponse } from "./server";

export function mapApiResponseToRecipeList(
    responseData: IRecipeResponse
): IRecipeItem[] {
    return responseData.recipes.map((recipeData: any) => ({
        imageUrl: recipeData.image,
        name: recipeData.name,
        rating: recipeData.rating,
        cuisine: recipeData.cuisine,
        ingredients: recipeData.ingredients,
        difficulty: recipeData.difficulty,
        totalTime: recipeData.prepTimeMinutes + recipeData.cookTimeMinutes,
        calories: recipeData.caloriesPerServing * recipeData.servings,
    }));
}
