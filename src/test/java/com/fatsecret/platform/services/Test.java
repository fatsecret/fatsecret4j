package com.fatsecret.platform.services;

import java.util.List;

import com.fatsecret.platform.model.*;

public class Test {

	public static void main(String[] args) {
        String key = "d93162ff153c49518a6583c6f644fc37";
        String secret = "3f8d8352d8b24b9cbccc801d35d65713";
		
        FatsecretService service = new FatsecretService(key, secret);
        service.getRecipe(315L);
        service.searchRecipes("Marinated Herb Chicken");
		
		Response<CompactRecipe> response = service.searchRecipes("chicken");
		
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
		Recipe recipe = service.getRecipe(84411L);
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
		
		Food food = service.getFood(4337L, Country.SWITZERLAND, Language.ENGLISH, true);
		System.out.println("==>> Food");
		System.out.println("Food: " + food.getName());

		List<FoodCategory> allFoodCategories = service.getAllFoodCategories();
		System.out.println("==>> Food categories");
		System.out.println("Size: " + allFoodCategories.size());

		List<FoodSubCategory> foodSubCategories = service.getFoodSubCategories(1);
		System.out.println("==>> Food sub categories");
		System.out.println("Size: " + foodSubCategories.size());

		DetailedFood detailedFood = service.getDetailedFood(20689071L, Country.UNITED_STATES, Language.ENGLISH);
		System.out.println("==>> Detailed food");
		System.out.println("Food: " + detailedFood.getName());
		System.out.println("Amount of food categories: " + detailedFood.getFoodCategories().size());
		
		Response<CompactFood> res = service.searchFoods("Zitronenkuchen", 0, Country.SWITZERLAND, Language.GERMAN);
		System.out.println("==>> Response");
		System.out.println("Total: " + res.getTotalResults());
		System.out.println("Max: " + res.getMaxResults());
		System.out.println("Size: " + res.getResults().size());
	}
}