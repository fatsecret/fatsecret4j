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
package com.fatsecret.platform.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fatsecret.platform.model.CompactFood;
import com.fatsecret.platform.model.Food;
import com.fatsecret.platform.utils.FoodUtility;

/**
 * This service class helps to get or search food items from fatsecret rest api
 *
 * @author Saurabh Rane
 * @version 1.0
 */
public class FoodService {
	/** Request Object */
	private Request request;
	
	/**
	 * Constructor to set values for APP_KEY and APP_SECRET
	 *
	 * @param APP_KEY		a value FatSecret API issues to you which helps this API identify you
	 * @param APP_SECRET	a secret FatSecret API issues to you which helps this API establish that it really is you
	 */
	public FoodService(String APP_KEY, String APP_SECRET) {
		request = new Request(APP_KEY, APP_SECRET);
	}
	
	/**
	 * Returns detailed nutritional information for the specified food
	 *
	 * @param foodId		the unique food identifier
	 * @return				food based on the identifier
	 */
	public Food getFood(Long foodId) {
		JSONObject response = request.getFood(foodId);
		if(response != null) {
			JSONObject food = response.getJSONObject("food");
			return FoodUtility.parseFoodFromJSONObject(food);
		}
		return null;
	}
	
	/**
	 * Returns response associated with the food items at zeroth page depending on the search query
	 * 
	 * @param query			search terms for querying food items
	 * @return				food items at zeroth page based on the query
	 */
	public Response<CompactFood> searchFoods(String query) {
		return searchFoods(query, 0);
	}

	/**
	 * Returns response associated with the food items depending on the search query and page number
	 * 
	 * @param query			search terms for querying food items
	 * @param pageNumber	page Number to search the food items
	 * @return				food items at a particular page number based on the query
	 */
	public Response<CompactFood> searchFoods(String query, Integer pageNumber) {
		JSONObject json = request.getFoods(query, pageNumber);
		
		if(json != null) {
			JSONObject foods = json.getJSONObject("foods");
			
			int maxResults = foods.getInt("max_results");
			int totalResults = foods.getInt("total_results");
			
			List<CompactFood> results = new ArrayList<CompactFood>();
			
			if(totalResults > maxResults * pageNumber) {
				 JSONArray food = foods.getJSONArray("food");
				results = FoodUtility.parseCompactFoodListFromJSONArray(food);
			}
			
			Response<CompactFood> response = new Response<CompactFood>();
			
			response.setPageNumber(pageNumber);
			response.setMaxResults(maxResults);
			response.setTotalResults(totalResults);
			response.setResults(results);
			
			return response;
		}		
		return null;
	}	
}
