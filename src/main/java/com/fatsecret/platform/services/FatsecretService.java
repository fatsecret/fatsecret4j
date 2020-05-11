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

import com.fatsecret.platform.utils.FoodCategoryUtility;
import com.fatsecret.platform.utils.FoodSubCategoryUtility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fatsecret.platform.model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import com.fatsecret.platform.utils.FoodUtility;
import com.fatsecret.platform.utils.RecipeUtility;

/**
 * This service class helps to get or search food or recipe items from fatsecret rest api
 *
 * @author Saurabh Rane
 * @version 2.0
 */
public class FatsecretService {

  /**
   * Request Object
   */
  private final Request request;

  /**
   * Constructor to set values for APP_KEY and APP_SECRET
   *
   * @param APP_KEY    a value FatSecret API issues to you which helps this API identify you
   * @param APP_SECRET a secret FatSecret API issues to you which helps this API establish that it
   *                   really is you
   */
  public FatsecretService(String APP_KEY, String APP_SECRET) {
    request = new Request(APP_KEY, APP_SECRET);
  }

  /**
   * Returns detailed nutritional information for the specified food
   *
   * @param foodId the unique food identifier
   * @return food based on the identifier
   */
  public Food getFood(Long foodId) {
    return getFood(foodId, Country.UNITED_STATES, Language.ENGLISH, false);
  }

  /**
   * Returns detailed nutritional information for the specified food
   *
   * @param foodId               the unique food identifier
   * @param country              localization country
   * @param language             localization language
   * @param includeSubCategories flag to include sub categories in response
   * @return food based on the identifier
   */
  public Food getFood(Long foodId, Country country, Language language,
      boolean includeSubCategories) {
    JSONObject response = request
        .getFood(foodId, country.getCode(), language.getCode(), includeSubCategories);

    try {
      if (response != null) {
        JSONObject food = response.getJSONObject("food");
        return FoodUtility.parseFoodFromJSONObject(food);
      }
    } catch (Exception e) {
      System.out.println("Exception: " + e.getMessage());
    }

    return null;
  }

  /**
   * Returns response associated with the food items at zeroth page depending on the search query
   *
   * @param query search terms for querying food items
   * @return food items at zeroth page based on the query
   */
  public Response<CompactFood> searchFoods(String query) {
    return searchFoods(query, 0);
  }

  /**
   * Returns response associated with the food items depending on the search query and page number
   *
   * @param query      search terms for querying food items
   * @param pageNumber page Number to search the food items
   * @return food items at a particular page number based on the query
   */
  public Response<CompactFood> searchFoods(String query, Integer pageNumber) {
    return searchFoods(query, pageNumber, Country.UNITED_STATES, Language.ENGLISH);
  }

  /**
   * Returns response associated with the food items depending on the search query and the
   * localization.
   *
   * @param query    search terms for querying food items
   * @param country  localization country
   * @param language localization language
   * @return food items at zeroth page base on the query and the localization
   */
  public Response<CompactFood> searchFoods(String query, Country country, Language language) {
    return searchFoods(query, 0, country, language);
  }

  /**
   * Returns response associated with the food items depending on the search query, page number and
   * localization.
   *
   * @param query      search terms for querying food items
   * @param pageNumber page number to search the food items
   * @param country    localization country
   * @param language   localization language
   * @return food items at a particular page number based on the query and the localization
   */
  public Response<CompactFood> searchFoods(String query, Integer pageNumber, Country country,
      Language language) {
    JSONObject json = request.searchFoods(query, pageNumber, country.getCode(), language.getCode());

    try {
      if (json != null) {
        JSONObject foods = json.getJSONObject("foods");

        int maxResults = foods.getInt("max_results");
        int totalResults = foods.getInt("total_results");

        List<CompactFood> results = new ArrayList<>();

        if (totalResults == 1) {
          JSONObject food = foods.getJSONObject("food");
          CompactFood compactFood = FoodUtility.parseCompactFoodFromJSONObject(food);
          results.add(compactFood);
        } else if (totalResults > maxResults * pageNumber) {
          JSONArray food = foods.getJSONArray("food");
          results = FoodUtility.parseCompactFoodListFromJSONArray(food);
        }

        Response<CompactFood> response = new Response<>();

        response.setPageNumber(pageNumber);
        response.setMaxResults(maxResults);
        response.setTotalResults(totalResults);
        response.setResults(results);

        return response;
      }
    } catch (Exception e) {
      System.out.println("Exception: " + e.getMessage());
    }

    return null;
  }

  /**
   * Returns detailed information for the specified recipe
   *
   * @param recipeId the unique recipe identifier
   * @return detailed information for the specified recipe
   */
  public Recipe getRecipe(Long recipeId) {
    JSONObject response = request.getRecipe(recipeId);

    try {
      if (response != null) {
        JSONObject recipe = response.getJSONObject("recipe");
        return RecipeUtility.parseRecipeFromJSONObject(recipe);
      }
    } catch (Exception e) {
      System.out.println("Exception: " + e.getMessage());
    }

    return null;
  }

  /**
   * Returns all fatsecret food categories.
   *
   * @return all food categories
   */
  public List<FoodCategory> getAllFoodCategories() {
    JSONObject response = request.getAllFoodCategories();
    if (response != null) {
      JSONObject foodCategories = response.getJSONObject("food_categories");
      JSONArray foodCategoryList = foodCategories.getJSONArray("food_category");
      return FoodCategoryUtility.parseFoodCategoryListFromJSONArray(foodCategoryList);
    }
    return Collections.emptyList();
  }

  /**
   * Returns all the sub categories for the food category provided by its id.
   *
   * @param foodCategoryId food category id
   * @return all sub categories for the food category
   */
  public List<FoodSubCategory> getFoodSubCategories(long foodCategoryId) {
    JSONObject response = request.getFoodSubCategories(foodCategoryId);
    if (response != null) {
      JSONObject foodSubCategories = response.getJSONObject("food_sub_categories");
      JSONArray foodSubCategoryList = foodSubCategories.getJSONArray("food_sub_category");
      return FoodSubCategoryUtility.parseFoodSubCategoryListFromJSONArray(foodSubCategoryList);
    }
    return Collections.emptyList();
  }

  /**
   * Returns response associated with the recipes at zeroth page depending on the search query
   *
   * @param query search terms for querying recipes
   * @return recipe items at zeroth page based on the query
   */
  public Response<CompactRecipe> searchRecipes(String query) {
    return searchRecipes(query, 0);
  }

  /**
   * Returns response associated with the recipes depending on the search query and page number
   *
   * @param query      search terms for querying recipes
   * @param pageNumber page Number to search the recipes
   * @return recipe items at a particular page number based on the query
   */
  public Response<CompactRecipe> searchRecipes(String query, Integer pageNumber) {
    JSONObject json = request.searchRecipes(query, pageNumber);
    Response<CompactRecipe> response = new Response<>();

    try {
      if (json != null) {
        JSONObject recipes = json.getJSONObject("recipes");
        int maxResults = recipes.getInt("max_results");
        int totalResults = recipes.getInt("total_results");

        List<CompactRecipe> results = new ArrayList<>();

        if (totalResults > maxResults * pageNumber) {
          JSONArray recipe = recipes.getJSONArray("recipe");
          results = RecipeUtility.parseCompactRecipeListFromJSONArray(recipe);
        }

        response.setPageNumber(pageNumber);
        response.setMaxResults(maxResults);
        response.setTotalResults(totalResults);
        response.setResults(results);

        return response;
      }
    } catch (Exception e) {
      System.out.println("Exception: " + e.getMessage());
    }
    return null;
  }
}
