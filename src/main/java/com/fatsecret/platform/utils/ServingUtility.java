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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fatsecret.platform.model.Serving;

/**
 * This utility class helps to get detailed information about serving(s) for food or recipe item(s) from fatsecret rest api
 *
 * @author Saurabh Rane
 * @version 2.0
 */
public class ServingUtility {
	
	/**
	 * Returns food nutrient values according to serving sizes
	 * 
	 * @param json			json object representing nutritional information of the food
	 * @return				food nutrient values according to serving sizes
	 */
	public static Serving parseServingFromJSONObject(JSONObject json) {		
		Serving serving = new Serving();

		try {
			Long servingId = Long.parseLong(json.getString("serving_id"));
			serving.setServingId(servingId);
		} catch(Exception ignore) {}

		try {
			String servingDescription = json.getString("serving_description");
			serving.setServingDescription(servingDescription);			
		} catch(Exception ignore) {}

		try {
			String servingUrl = json.getString("serving_url");
			serving.setServingUrl(servingUrl);
		} catch(Exception ignore) {}

		try {
			String metricServingAmountString = json.getString("metric_serving_amount");
			BigDecimal metricServingAmount = new BigDecimal(metricServingAmountString);

			serving.setMetricServingAmount(metricServingAmount);
		} catch(Exception ignore) {}
		
		try {
			String metricServingUnit = json.getString("metric_serving_unit");			
			serving.setMetricServingUnit(metricServingUnit);
		} catch(Exception ignore) {}
		
		try {
			String numberOfUnitsString = json.getString("number_of_units");
			BigDecimal numberOfUnits = new BigDecimal(numberOfUnitsString);

			serving.setNumberOfUnits(numberOfUnits);
		} catch(Exception ignore) {}
		
		try {
			String measurementDescription = json.getString("measurement_description");			
			serving.setMeasurementDescription(measurementDescription);
		} catch(Exception ignore) {}
		
		try {
			String caloriesString = json.getString("calories");
			BigDecimal calories = new BigDecimal(caloriesString);

			serving.setCalories(calories);
		} catch(Exception ignore) {}
		
		try {
			String carbohydrateString = json.getString("carbohydrate");
			BigDecimal carbohydrate = new BigDecimal(carbohydrateString);

			serving.setCarbohydrate(carbohydrate);
		} catch(Exception ignore) {}
		
		try {
			String proteinString = json.getString("protein");
			BigDecimal protein = new BigDecimal(proteinString);

			serving.setProtein(protein);
		} catch(Exception ignore) {}
		
		try {
			String fatString = json.getString("fat");
			BigDecimal fat = new BigDecimal(fatString);

			serving.setFat(fat);
		} catch(Exception ignore) {}
		
		try {
			String saturatedFatString = json.getString("saturated_fat");
			BigDecimal saturatedFat = new BigDecimal(saturatedFatString);

			serving.setSaturatedFat(saturatedFat);
		} catch(Exception ignore) {}
		
		try {
			String polyunsaturatedFatString = json.getString("polyunsaturated_fat");
			BigDecimal polyunsaturatedFat = new BigDecimal(polyunsaturatedFatString);

			serving.setPolyunsaturatedFat(polyunsaturatedFat);
		} catch(Exception ignore) {}
		
		try {
			String monounsaturatedFatString = json.getString("monounsaturated_fat");
			BigDecimal monounsaturatedFat = new BigDecimal(monounsaturatedFatString);

			serving.setMonounsaturatedFat(monounsaturatedFat);
		} catch(Exception ignore) {}
		
		try {
			String transFatString = json.getString("trans_fat");
			BigDecimal transFat = new BigDecimal(transFatString);

			serving.setTransFat(transFat);
		} catch(Exception ignore) {}
		
		try {
			String cholesterolString = json.getString("cholesterol");
			BigDecimal cholesterol = new BigDecimal(cholesterolString);

			serving.setCholesterol(cholesterol);
		} catch(Exception ignore) {}

		try {
			String sodiumString = json.getString("sodium");
			BigDecimal sodium = new BigDecimal(sodiumString);

			serving.setSodium(sodium);
		} catch(Exception ignore) {}

		try {
			String potassiumString = json.getString("potassium");
			BigDecimal potassium = new BigDecimal(potassiumString);

			serving.setPotassium(potassium);
		} catch(Exception ignore) {}

		try {
			String fiberString = json.getString("fiber");
			BigDecimal fiber = new BigDecimal(fiberString);

			serving.setFiber(fiber);
		} catch(Exception ignore) {}

		try {
			String sugarString = json.getString("sugar");
			BigDecimal sugar = new BigDecimal(sugarString);

			serving.setSugar(sugar);
		} catch(Exception ignore) {}

		try {
			String vitaminAString = json.getString("vitamin_a");
			BigDecimal vitaminA = new BigDecimal(vitaminAString);

			serving.setVitaminA(vitaminA);
		} catch(Exception ignore) {}

		try {
			String vitaminCString = json.getString("vitamin_c");
			BigDecimal vitaminC = new BigDecimal(vitaminCString);

			serving.setVitaminC(vitaminC);
		} catch(Exception ignore) {}

		try {
			String calciumString = json.getString("calcium");
			BigDecimal calcium = new BigDecimal(calciumString);

			serving.setCalcium(calcium);
		} catch(Exception ignore) {}

		try {
			String ironString = json.getString("iron");
			BigDecimal iron = new BigDecimal(ironString);

			serving.setIron(iron);
		} catch(Exception ignore) {}
		
		return serving;
	}
	
	/**
	 * Returns a list of food nutrient values according to different serving sizes
	 * 
	 * @param array			json array representing a list of nutrient values according to different serving sizes for a food
	 * @return				list of food nutrient values according to different serving sizes
	 */
	public static List<Serving> parseServingsFromJSONArray(JSONArray array) {
		List<Serving> servings = new ArrayList<Serving>();
		
		for(int i = 0; i < array.length(); i++) {
			JSONObject obj = array.getJSONObject(i);
			Serving serving = parseServingFromJSONObject(obj);
			servings.add(serving);
		}			
		
		return servings;
	}

}
