/*
 * Copyright (C) 2016 Saurabh Rane
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fatsecret.platform.utils;

/**
 * This utility class helps to get detailed information about recipe item(s) from fatsecret rest api
 *
 * @author Saurabh Rane
 * @version 1.0
 */
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fatsecret.platform.model.Category;
import com.fatsecret.platform.model.CompactRecipe;
import com.fatsecret.platform.model.Direction;
import com.fatsecret.platform.model.Ingredient;
import com.fatsecret.platform.model.Recipe;
import com.fatsecret.platform.model.Serving;

public class RecipeUtility {

	/**
	 * Returns detailed information about the recipe
	 * 
	 * @param json			json object representing of the recipe
	 * @return				detailed information about the recipe
	 */
	public static Recipe parseRecipeFromJSONObject(JSONObject json) {
		String name = json.getString("recipe_name");
		String url = json.getString("recipe_url");
		String description = json.getString("recipe_description");
		Long id = Long.parseLong(json.getString("recipe_id"));
		
		List<String> images = new ArrayList<String>();
		JSONObject recipeImages = json.getJSONObject("recipe_images");
		JSONArray recipeImage = null;
		try {
			recipeImage = recipeImages.getJSONArray("recipe_image");
		} catch(Exception e) {
			recipeImage = null;
		}
		
		if(recipeImage != null) {
			for(int i = 0; i < recipeImage.length(); i++) {
				String image = recipeImage.getString(i);
				images.add(image);
			}
		} else {
			String image = recipeImages.getString("recipe_image");
			images.add(image);
		}
				
		Integer rating = Integer.parseInt(json.getString("rating"));
		
		List<String> types = new ArrayList<String>();
		JSONObject recipeTypes = json.getJSONObject("recipe_types");
		
		JSONArray recipeType = null;
		try {
			recipeType = recipeTypes.getJSONArray("recipe_type");
		} catch(Exception e) {
			recipeType = null;
		}

		if(recipeType != null) {
			for(int i = 0; i < recipeType.length(); i++) {
				String type = recipeType.getString(i);
				types.add(type);
			}
		} else {
			String type = recipeTypes.getString("recipe_type");
			types.add(type);
		}
		
		BigDecimal numberOfServings = new BigDecimal(json.getString("number_of_servings"));
		
		Integer preparationTime = 0;
		try {
			preparationTime = Integer.parseInt(json.getString("preparation_time_min"));
		} catch(Exception ignore) {
			preparationTime = 0;
		}
		
		Integer cookingTime = 0;
		
		try {
			cookingTime = Integer.parseInt(json.getString("cooking_time_min"));
		} catch(Exception ignore) {
			cookingTime = 0;
		}
		
		List<Category> categories = new ArrayList<Category>();
		JSONObject recipeCategories = json.getJSONObject("recipe_categories");
		JSONArray recipeCategory = null;

		try {
			recipeCategory = recipeCategories.getJSONArray("recipe_category");
		} catch(Exception e) {
			recipeCategory = null;
		}

		if(recipeCategory != null) {
			for(int i = 0; i < recipeCategory.length(); i++) {
				JSONObject recipeCategoryObj = recipeCategory.getJSONObject(i);
				Category category = parseJsonToCategory(recipeCategoryObj);
				categories.add(category);
			}
		} else {
			JSONObject recipeCategoryObj = recipeCategories.getJSONObject("recipe_category");
			Category category = parseJsonToCategory(recipeCategoryObj);
			categories.add(category);
		}
		
		JSONObject servingSizes = json.getJSONObject("serving_sizes");
		JSONObject servingObj = servingSizes.getJSONObject("serving");
		Serving serving = ServingUtility.parseServingFromJSONObject(servingObj);
		
		JSONObject directionsObj = json.getJSONObject("directions");
		List<Direction> directions = new ArrayList<Direction>();
		JSONArray directionArray = null;
		try {
			directionArray = directionsObj.getJSONArray("direction");
		} catch(Exception e) {
			directionArray = null;
		}
		
		if(directionArray != null) {
			for(int i = 0; i < directionArray.length(); i++) {
				JSONObject directionObj = directionArray.getJSONObject(i);
				Direction direction = parseJsonToDirection(directionObj);
				directions.add(direction);
			}
		} else {
			JSONObject directionObj = directionsObj.getJSONObject("direction");
			Direction direction = parseJsonToDirection(directionObj);
			directions.add(direction);
		}
		
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		JSONObject ingredientsObj = json.getJSONObject("ingredients");
		JSONArray ingredientArray = null;
		try {
			ingredientArray = ingredientsObj.getJSONArray("ingredient");
		} catch(Exception e) {
			ingredientArray = null;
		}

		if(ingredientArray != null) {
			for(int i = 0; i < ingredientArray.length(); i++) {
				JSONObject ingredientObj = ingredientArray.getJSONObject(i);
				Ingredient ingredient = parseJsonToIngredient(ingredientObj);
				ingredients.add(ingredient);				
			}
		} else {
			JSONObject ingredientObj = ingredientsObj.getJSONObject("ingredient");
			Ingredient ingredient = parseJsonToIngredient(ingredientObj);
			ingredients.add(ingredient);
		}

		Recipe recipe = new Recipe();

		recipe.setName(name);
		recipe.setUrl(url);
		recipe.setDescription(description);
		recipe.setId(id);
		recipe.setImages(images);
		recipe.setRating(rating);
		recipe.setTypes(types);
		recipe.setNumberOfServings(numberOfServings);
		recipe.setPreparationTime(preparationTime);
		recipe.setCookingTime(cookingTime);
		recipe.setCategories(categories);
		recipe.setServing(serving);
		recipe.setDirections(directions);
		recipe.setIngredients(ingredients);

		return recipe;
	}
	
	/**
	 * Returns information about the compact item
	 * 
	 * @param json			json object representing of the recipe
	 * @return				compact recipe item
	 */
	public static CompactRecipe parseCompactRecipeFromJSONObject(JSONObject json) {

		String name = json.getString("recipe_name");
		String url = json.getString("recipe_url");
		String description = json.getString("recipe_description");
		Long id = Long.parseLong(json.getString("recipe_id"));
		
		List<String> images = new ArrayList<String>();
		
		try {
			String image = json.getString("recipe_image");
			images.add(image);
		} catch(Exception ignore) {}
		
		CompactRecipe recipe = new CompactRecipe();
		
		recipe.setName(name);
		recipe.setUrl(url);
		recipe.setDescription(description);
		recipe.setId(id);
		recipe.setImages(images);
		
		return recipe;
		
	}
	
	/**
	 * Returns a list of compact recipe items
	 * 
	 * @param array			json array representing a list of compact recipe
	 * @return				list of compact recipe items
	 */
	public static List<CompactRecipe> parseCompactRecipeListFromJSONArray(JSONArray array) {
		List<CompactRecipe> recipes = new ArrayList<CompactRecipe>();
		for(int i = 0; i < array.length(); i++) {
			JSONObject obj = array.getJSONObject(i);
			CompactRecipe recipe = parseCompactRecipeFromJSONObject(obj);
			recipes.add(recipe);
		}
		return recipes;
	}
	
	/**
	 * Returns the category that the recipe is classified under
	 * 
	 * @param json			json object representing of the category
	 * @return				the category that the recipe is classified under
	 */
	public static Category parseJsonToCategory(JSONObject json) {
		String url = json.getString("recipe_category_url");
		String name = json.getString("recipe_category_name");
		
		Category category = new Category();
		category.setUrl(url);
		category.setName(name);

		return category;
	}
	
	/**
	 * Returns direction involved in creating the recipe
	 * 
	 * @param json			json object representing of the direction
	 * @return				direction involved in creating the recipe
	 */
	public static Direction parseJsonToDirection(JSONObject json) {
		Integer number = Integer.parseInt(json.getString("direction_number"));
		String description = json.getString("direction_description");

		Direction direction = new Direction();
		
		direction.setNumber(number);
		direction.setDescription(description);

		return direction;
	}
	
	/**
	 * Returns detailed information about the ingredient
	 * 
	 * @param json			json object representing of the ingredient
	 * @return				detailed information about the ingredient
	 */
	public static Ingredient parseJsonToIngredient(JSONObject json) {
		
		Long foodId = Long.parseLong(json.getString("food_id"));
		Long servingId = Long.parseLong(json.getString("serving_id"));
		String description = json.getString("ingredient_description");
		String name = json.getString("food_name");
		String url = json.getString("ingredient_url");
		BigDecimal numberOfUnits = new BigDecimal(json.getString("number_of_units"));
		String measurementDescription = json.getString("measurement_description");

		Ingredient ingredient = new Ingredient();
		
		ingredient.setFoodId(foodId);
		ingredient.setServingId(servingId);
		ingredient.setDescription(description);
		ingredient.setName(name);
		ingredient.setUrl(url);
		ingredient.setNumberOfUnits(numberOfUnits);
		ingredient.setMeasurementDescription(measurementDescription);
		
		return ingredient;
	}
}
