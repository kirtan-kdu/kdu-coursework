import { mapApiResponseToRecipeList } from "./mapper";
import { setRecipes } from "./repository";

export interface IRecipeItem {
    imageUrl: string;
    name: string;
    rating: number;
    cuisine: string;
    ingredients: string[];
    difficulty: string;
    totalTime: number;
    calories: number;
}

export interface IRecipeResponse {
    recipes: IRecipeItem[];
    total: number;
    skip: number;
    limit: number;
}

export const fetchRecipes = (): Promise<IRecipeResponse> => {
    return fetch("https://dummyjson.com/recipes")
        .then((response) => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .catch((error) => {
            console.error(
                "There has been a problem with your fetch operation: ",
                error
            );
        });
};

export const searchRecipes = (recipeName: string): Promise<IRecipeResponse> => {
    return fetch(`https://dummyjson.com/recipes/search?q=${recipeName}`)
        .then((response) => {
            if (!response.ok) {
                throw new Error(
                    `HTTP error from external API! status: ${response.status}`
                );
            }
            return response.json();
        })
        .catch((error) => {
            console.error(
                "There has been a problem with your fetch operation: ",
                error
            );
        });
};

// searchRecipes("margherita")
//     .then((responseData: IRecipeResponse) =>
//         mapApiResponseToRecipeList(responseData)
//     )
//     .then((recipe) => console.log(recipe));
