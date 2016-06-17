package com.fatsecret.platform.services;

import java.util.List;

import com.fatsecret.platform.model.CompactFood;
import com.fatsecret.platform.model.CompactRecipe;
import com.fatsecret.platform.model.Direction;
import com.fatsecret.platform.model.Food;
import com.fatsecret.platform.model.Ingredient;
import com.fatsecret.platform.model.Recipe;

public class Test {

	public static void main(String[] args) {
		String key = "your key";
		String secret = "your secret";
		
		RecipeService recipeService = new RecipeService(key, secret);
		recipeService.getRecipe(315L);
		recipeService.searchRecipes("Marinated Herb Chicken");
		
		Response<CompactRecipe> response = recipeService.searchRecipes("chicken");
		
		System.out.println("Total Results: " + response.getTotalResults());
		System.out.println("Max Results: " + response.getMaxResults());
		System.out.println("Page Number: " + response.getPageNumber());
				
		List<CompactRecipe> list = response.getResults();
		
		int i = 1;
		for(CompactRecipe recipe : list) {
			System.out.println(i + ": " + recipe.getId() + " - " + recipe.getName() + ", Description: " + recipe.getDescription());
			i++;
		}
		
		System.out.println("==================================================================================================================================");
		Recipe recipe = recipeService.getRecipe(84411L);
		System.out.println(recipe.getId() + " - " + recipe.getName() + ", Description: " + recipe.getDescription());
		System.out.println("Prep Time: " + recipe.getPreparationTime() + ", Cook Time: " + recipe.getCookingTime());

		System.out.println("==>> Directions");

		for(Direction direction: recipe.getDirections()) {
			System.out.println(direction.getNumber() + " - " + direction.getDescription());
		}
		
		System.out.println("==>> Ingredients");

		for(Ingredient ingredient: recipe.getIngredients()) {
			System.out.println(ingredient.getName() + " - " + ingredient.getNumberOfUnits() + " " + ingredient.getMeasurementDescription());
		}
		
		FoodService foodService = new FoodService(key, secret);
		Food food = foodService.getFood(60810L);
		System.out.println("==>> Food");
		System.out.println("Food: " + food.getName());
		
		Response<CompactFood> res = foodService.searchFoods("biryani", 1);
		System.out.println("==>> Response");
		System.out.println("Total: " + res.getTotalResults());
		System.out.println("Max: " + res.getMaxResults());
		System.out.println("Size: " + res.getResults().size());
	}
}
