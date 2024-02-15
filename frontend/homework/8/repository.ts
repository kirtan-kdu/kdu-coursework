import { IRecipeItem } from "./server";

export const recipesList: IRecipeItem[] = [];

export function setRecipes(newRecipes: IRecipeItem[]) {
    recipesList.length = 0; // Clear the array
    recipesList.push(...newRecipes); // Push new items into the array
}
