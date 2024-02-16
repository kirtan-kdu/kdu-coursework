import { IRecipeItem } from "./server";

export const recipesList: IRecipeItem[] = [];

export function setRecipes(newRecipes: IRecipeItem[]) {
    recipesList.length = 0;
    recipesList.push(...newRecipes);
}
