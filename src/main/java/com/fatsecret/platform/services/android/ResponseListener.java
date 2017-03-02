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
package com.fatsecret.platform.services.android;

import com.fatsecret.platform.model.CompactFood;
import com.fatsecret.platform.model.CompactRecipe;
import com.fatsecret.platform.model.Food;
import com.fatsecret.platform.model.Recipe;
import com.fatsecret.platform.services.Response;

/** 
 * Callback listener interface for delivering parsed response
 *
 * @author Saurabh Rane
 * @version 2.0
 */
public interface ResponseListener {
	
	/** 
	 * Called when a food response is received.
	 *
	 * @param food			the food item from the response
	 */
	default public void onFoodResponse(Food food) {
		System.out.println("ResponseListener onFoodResponse");
	}
	
	/**
	 * Called when a compact food list response is received.
	 * 
	 * @param response			the response for the food item list
	 */
	default public void onFoodListRespone(Response<CompactFood> response) {
		System.out.println("ResponseListener onFoodListRespone");
	}

	/** 
	 * Called when a recipe response is received.
	 *
	 * @param recipe			the recipe item from the response
	 */
	default public void onRecipeResponse(Recipe recipe) {
		System.out.println("ResponseListener onRecipeResponse");
	}
	
	/** 
	 * Called when a compact recipe list response is received.
	 * 
	 * @param response			the response for the recipe item list 
	 */
	default public void onRecipeListRespone(Response<CompactRecipe> response) {
		System.out.println("ResponseListener onRecipeListRespone");
	}
}