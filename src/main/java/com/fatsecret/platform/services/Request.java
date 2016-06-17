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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

/**
 * This class helps in sending requests to fatsecret rest api
 *
 * @author Saurabh Rane
 * @version 1.0
 */
public class Request {
	
	/** Request Builder */
	private RequestBuilder builder;
	
	/**
	 * Constructor to set values for APP_KEY and APP_SECRET
	 *
	 * @param APP_KEY 		a value FatSecret API issues to you which helps this API identify you
	 * @param APP_SECRET	a secret FatSecret API issues to you which helps this API establish that it really is you
	 */
	public Request(String APP_KEY, String APP_SECRET) {
		builder = new RequestBuilder(APP_KEY, APP_SECRET);
	}
	
	/**
	 * Returns the json object associated with the food items depending on the search query and page number
	 * 
	 * @param query			search terms for querying food items
	 * @param pageNumber	page Number to search the food items
	 * @return				food items at a particular page number based on the query
	 */
	public JSONObject getFoods(String query, int pageNumber) {
		try {
			String apiUrl = builder.buildFoodsSearchUrl(query, pageNumber);
			return getJSONResponse(apiUrl);
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * Returns the json object associated with the food id with nutritional information
	 *
	 * @param id			the unique food identifier
	 * @return				food based on the identifier
	 */
	public JSONObject getFood(Long id) {
		try {
			String apiUrl = builder.buildFoodSearchUrl(id);
			return getJSONResponse(apiUrl);
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * Returns the json object associated with the recipes depending on the search query
	 *
	 * @param query			search terms for querying recipes
	 * @param pageNumber	page Number to search the recipes
	 * @return				recipes at a particular page number based on the query
	 */
	public JSONObject getRecipes(String query, int pageNumber) {
		try {
			String apiUrl = builder.buildRecipesSearchUrl(query, pageNumber);
			return getJSONResponse(apiUrl);
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * Returns the json object associated with general information about the recipe item with detailed nutritional information for the standard serving
	 *
	 * @param id			the unique recipe identifier
	 * @return				recipe based on the identifier
	 */
	public JSONObject getRecipe(Long id) {
		
		try {
			String apiUrl = builder.buildRecipeSearchUrl(id);
			return getJSONResponse(apiUrl);
		} catch (Exception e) {

		}
		return null;
	}
	
	/**
	 * Returns json object associated with the response from fatsecret api for given url
	 *
	 * @param apiUrl		the rest url which will be sent to fatsecret platform server
	 * @return				json object containing search results for given url
	 */
	public JSONObject getJSONResponse(String apiUrl) {
		
		try {
			URL url = new URL(apiUrl);
			URLConnection api = url.openConnection();
			String line;
			StringBuilder builder = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(api.getInputStream()));

			while ((line = reader.readLine()) != null) builder.append(line);

			JSONObject json = new JSONObject(builder.toString());

			return json;
		} catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
		return null;
	}
}