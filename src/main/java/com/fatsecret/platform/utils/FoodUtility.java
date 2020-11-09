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

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fatsecret.platform.model.Food;
import com.fatsecret.platform.model.Serving;
import com.fatsecret.platform.model.CompactFood;

/**
 * This utility class helps to get detailed information about food item(s) from fatsecret rest api
 *
 * @author Saurabh Rane
 * @version 2.0
 */
public class FoodUtility {

    /**
     * Returns detailed information about the food
     *
     * @param json json object representing of the food
     * @return detailed information about the food
     */
    public static Food parseFoodFromJSONObject(JSONObject json) {
        String name = json.getString("food_name");
        String url = json.getString("food_url");
        String type = json.getString("food_type");
        Long id = Long.parseLong(json.getString("food_id"));
        String brandName = "";

        try {
            brandName = json.getString("brand_name");
        } catch (Exception ignore) {
        }

        JSONObject servingsObj = json.getJSONObject("servings");

        JSONArray array = null;
        List<Serving> servings = new ArrayList<Serving>();

        try {
            array = servingsObj.getJSONArray("serving");
            servings = ServingUtility.parseServingsFromJSONArray(array);
        } catch (Exception ignore) {
            System.out.println("Servings not found");
            array = null;
        }

        if (array == null) {
            try {
                JSONObject servingObj = servingsObj.getJSONObject("serving");
                Serving serving = ServingUtility.parseServingFromJSONObject(servingObj);
                servings.add(serving);
            } catch (Exception ignore) {
                System.out.println("Serving not found");
            }
        }

        Food food = new Food();

        food.setName(name);
        food.setUrl(url);
        food.setType(type);
        food.setId(id);
        food.setBrandName(brandName);
        food.setServings(servings);

        return food;
    }

    /**
     * Returns information about the compact food
     *
     * @param json json object representing of the food
     * @return compact food object from the json
     */
    public static CompactFood parseCompactFoodFromJSONObject(JSONObject json) {

        String name = json.getString("food_name");
        String url = json.getString("food_url");
        String type = json.getString("food_type");
        String description = json.getString("food_description");
        Long id = Long.parseLong(json.getString("food_id"));
        String brandName = type.equals("Brand") ? json.getString("brand_name") : null;

        CompactFood food = new CompactFood();

        food.setName(name);
        food.setUrl(url);
        food.setType(type);
        food.setDescription(description);
        food.setId(id);
        food.setBrandName(brandName);

        return food;
    }

    /**
     * Returns a list of compact food items
     *
     * @param array json array representing a list of compact food
     * @return list of compact food items
     */
    public static List<CompactFood> parseCompactFoodListFromJSONArray(JSONArray array) {
        List<CompactFood> foods = new ArrayList<CompactFood>();

        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = array.getJSONObject(i);

            CompactFood food = parseCompactFoodFromJSONObject(obj);

            foods.add(food);
        }

        return foods;
    }
}
