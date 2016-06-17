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
package com.fatsecret.platform.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * This class represents detailed information about the recipe item.
 *
 * @author Saurabh Rane
 * @version 1.0
 */
public class Recipe extends CompactRecipe {
	
	/** The overall average rating of a recipe from FatSecret members out of five */
	private Integer rating;
	
	/** A list of the types that the recipe is classified under */
	private List<String> types;
	
	/** The number of servings the recipe is intended for */
	private BigDecimal numberOfServings;
	
	/** The time in minutes to prepare the recipe (where available) */
	private Integer preparationTime;

	/** The time in minutes to cook the recipe (where available) */
	private Integer cookingTime;
	
	/** A list of the categories that the recipe is classified under */
	private List<Category> categories;

	/** The complete nutritional information */
	private Serving serving;
	
	/** A list of the directions/steps involved in creating the recipe */
	private List<Direction> directions;
	
	/** A list of the ingredients that make up the recipe */
	private List<Ingredient> ingredients;
	
	/**
	 * Returns the average rating of the recipe
	 * 
	 * @return		the average rating of the recipe
	 */
	public Integer getRating() {
		return rating;
	}
	
	/**
	 * Sets the average rating of the recipe
	 * 
	 * @param		rating the average rating of the recipe
	 */
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	/**
	 * Returns the list of the types that the recipe is classified under
	 * 
	 * @return		the list of the types that the recipe is classified under
	 */
	public List<String> getTypes() {
		return types;
	}
	
	/**
	 * Sets the list of the types that the recipe is classified under
	 * 
	 * @param		types the list of the types that the recipe is classified under
	 */
	public void setTypes(List<String> types) {
		this.types = types;
	}
	
	/**
	 * Returns the number of servings the recipe is intended for
	 * 
	 * @return		the number of servings the recipe is intended for
	 */
	public BigDecimal getNumberOfServings() {
		return numberOfServings;
	}

	/**
	 * Sets the number of servings the recipe is intended for
	 * 
	 * @param		numberOfServings the number of servings the recipe is intended for
	 */
	public void setNumberOfServings(BigDecimal numberOfServings) {
		this.numberOfServings = numberOfServings;
	}
	
	/**
	 * Returns the time in minutes to prepare the recipe
	 * 
	 * @return		the time in minutes to prepare the recipe
	 */
	public Integer getPreparationTime() {
		return preparationTime;
	}
	
	/**
	 * Sets the time in minutes to prepare the recipe
	 * 
	 * @param		preparationTime the time in minutes to prepare the recipe
	 */
	public void setPreparationTime(Integer preparationTime) {
		this.preparationTime = preparationTime;
	}
	
	/**
	 * Returns the time in minutes to cook the recipe
	 * 
	 * @return		the time in minutes to cook the recipe
	 */
	public Integer getCookingTime() {
		return cookingTime;
	}
	
	/**
	 * Sets the time in minutes to cook the recipe
	 * 
	 * @param		cookingTime the time in minutes to cook the recipe
	 */
	public void setCookingTime(Integer cookingTime) {
		this.cookingTime = cookingTime;
	}
	
	/**
	 * Returns the list of the categories that the recipe is classified under
	 * 
	 * @return		the list of the categories that the recipe is classified under
	 */
	public List<Category> getCategories() {
		return categories;
	}
	
	/**
	 * Sets the list of the categories that the recipe is classified under
	 * 
	 * @param		categories the list of the categories that the recipe is classified under
	 */
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	/**
	 * Returns the complete nutritional information
	 * 
	 * @return		the complete nutritional information
	 */
	public Serving getServing() {
		return serving;
	}
	
	/**
	 * Sets the complete nutritional information
	 * 
	 * @param		serving the complete nutritional information
	 */
	public void setServing(Serving serving) {
		this.serving = serving;
	}

	/**
	 * Returns the list of the directions/steps involved in creating the recipe
	 * 
	 * @return		the list of the directions/steps involved in creating the recipe
	 */
	public List<Direction> getDirections() {
		return directions;
	}
	
	/**
	 * Sets the list of the directions/steps involved in creating the recipe
	 * 
	 * @param		directions the list of the directions/steps involved in creating the recipe
	 */
	public void setDirections(List<Direction> directions) {
		this.directions = directions;
	}
	
	/**
	 * Returns the list of the ingredients that make up the recipe
	 * 
	 * @return		the list of the ingredients that make up the recipe
	 */
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	
	/**
	 * Sets the list of the ingredients that make up the recipe
	 * 
	 * @param		ingredients the list of the ingredients that make up the recipe
	 */
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
}