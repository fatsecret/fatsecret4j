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

/**
 * This class represents nutrient values about the recipe item according to serving size.
 *
 * @author Saurabh Rane
 * @version 2.0
 */
public class Serving {
	
	/** The unique identifier of a food serving. E.G.: "100g" of "Spaghetti" */
	private Long servingId;

	/** The full description of the serving size. E.G.: "1 cup" or "100 g" */
	private String servingDescription;
	
	/** URL of the serving size for this food item on <a href="www.fatsecret.com">Fatsecret website</a> */
	private String servingUrl;
	
	/** The metric quantity combined with metricServingUnit to derive the total standardized quantity of the serving (where available) */
	private BigDecimal metricServingAmount;
	
	/** The metric unit of measure for the serving size, either "g" or "ml" or "oz", combined with metricServingAmount to derive the total standardized quantity of the serving (where available) */
	private String metricServingUnit;
	
	/** The number of units in this standard serving size. For instance, if the serving description is "2 tablespoons" the number of units is "2", while if the serving size is "1 cup" the number of units is "1" */
	private BigDecimal numberOfUnits;
	
	/** A description of the unit of measure used in the serving description. For instance, if the description is "1/2 cup" the measurement description is "cup", while if the serving size is "100 g" the measurement description is "g" */
	private String measurementDescription;
	
	/** Total calories in kcal. Always returned with a precision of 0 decimal places */
	private BigDecimal calories;
	
	/** Total carbohydrate in grams. Always returned with a precision of 2 decimal places */
	private BigDecimal carbohydrate;

	/** Protein in grams. Always returned with a precision of 2 decimal places */
	private BigDecimal protein;
	
	/** Total fat in grams. Always returned with a precision of 2 decimal places */
	private BigDecimal fat;
	
	/** Saturated fat in grams. Always returned with a precision of 3 decimal places */
	private BigDecimal saturatedFat;

	/** Polyunsaturated fat in grams. Always returned with a precision of 3 decimal places */
	private BigDecimal polyunsaturatedFat;
	
	/** Monounsaturated fat in grams. Always returned with a precision of 3 decimal places */
	private BigDecimal monounsaturatedFat;

	/** Trans fat in grams. Always returned with a precision of 3 decimal places */
	private BigDecimal transFat;

	/** Cholesterol in milligrams. Always returned with a precision of 0 decimal places */
	private BigDecimal cholesterol;
	
	/** Sodium in milligrams. Always returned with a precision of 0 decimal places */
	private BigDecimal sodium;
	
	/** Potassium in milligrams. Always returned with a precision of 0 decimal places */
	private BigDecimal potassium;
	
	/** Dietary fiber in grams. Always returned with a precision of 1 decimal place */
	private BigDecimal fiber;
	
	/** Sugar in grams. Always returned with a precision of 2 decimal places */
	private BigDecimal sugar;
	
	/** The percentage of daily recommended vitamin A, based on a 2000 calorie diet */
	private BigDecimal vitaminA;
	
	/** The percentage of daily recommended vitamin C, based on a 2000 calorie diet */
	private BigDecimal vitaminC;
	
	/** The percentage of daily recommended calcium, based on a 2000 calorie diet */
	private BigDecimal calcium;
	
	/** The percentage of daily recommended iron, based on a 2000 calorie diet */
	private BigDecimal iron;
	
	/**
	 * Returns the unique serving identifier
	 * 
	 * @return		the unique serving identifier
	 */
	public Long getServingId() {
		return servingId;
	}
	
	/**
	 * Sets the unique serving identifier
	 * 
	 * @param		servingId the unique serving identifier
	 */
	public void setServingId(Long servingId) {
		this.servingId = servingId;
	}
	
	/**
	 * Returns the full description of the serving size
	 * 
	 * @return		the full description of the serving size
	 */
	public String getServingDescription() {
		return servingDescription;
	}
	
	/**
	 * Sets the full description of the serving size
	 * 
	 * @param		servingDescription the full description of the serving size
	 */
	public void setServingDescription(String servingDescription) {
		this.servingDescription = servingDescription;
	}
	
	/**
	 * Returns the URL of the serving size for this food item
	 * 
	 * @return		the URL of the serving size for this food item
	 */
	public String getServingUrl() {
		return servingUrl;
	}
	
	/**
	 * Sets the URL of the serving size for this food item
	 * 
	 * @param		servingUrl the URL of the serving size for this food item
	 */
	public void setServingUrl(String servingUrl) {
		this.servingUrl = servingUrl;
	}
	
	/**
	 * Returns the metric quantity of the serving
	 * 
	 * @return		the metric quantity of the serving
	 */
	public BigDecimal getMetricServingAmount() {
		return metricServingAmount;
	}
	
	/**
	 * Sets the metric quantity of the serving
	 * 
	 * @param		metricServingAmount the metric quantity of the serving
	 */
	public void setMetricServingAmount(BigDecimal metricServingAmount) {
		this.metricServingAmount = metricServingAmount;
	}
	
	/**
	 * Returns the metric unit of measure for the serving size
	 * 
	 * @return		the metric unit of measure for the serving size
	 */
	public String getMetricServingUnit() {
		return metricServingUnit;
	}
	
	/**
	 * Sets the metric unit of measure for the serving size
	 * 
	 * @param		metricServingUnit the metric unit of measure for the serving size
	 */
	public void setMetricServingUnit(String metricServingUnit) {
		this.metricServingUnit = metricServingUnit;
	}
	
	/**
	 * Returns the number of units in this standard serving size
	 * 
	 * @return		the number of units in this standard serving size
	 */
	public BigDecimal getNumberOfUnits() {
		return numberOfUnits;
	}
	
	/**
	 * Sets the number of units in this standard serving size
	 * 
	 * @param		numberOfUnits the number of units in this standard serving size
	 */
	public void setNumberOfUnits(BigDecimal numberOfUnits) {
		this.numberOfUnits = numberOfUnits;
	}
	
	/**
	 * Returns the description of the unit of measure used in the serving description
	 * 
	 * @return		the description of the unit of measure used in the serving description
	 */
	public String getMeasurementDescription() {
		return measurementDescription;
	}
	
	/**
	 * Sets the description of the unit of measure used in the serving description
	 * 
	 * @param		measurementDescription the description of the unit of measure used in the serving description
	 */
	public void setMeasurementDescription(String measurementDescription) {
		this.measurementDescription = measurementDescription;
	}
	
	/**
	 * Returns the total calories in kcal
	 * 
	 * @return		the total calories in kcal
	 */
	public BigDecimal getCalories() {
		return calories;
	}
	
	/**
	 * Sets the total calories in kcal
	 * 
	 * @param		calories the total calories in kcal
	 */
	public void setCalories(BigDecimal calories) {
		this.calories = calories;
	}

	/**
	 * Returns the total carbohydrate content in grams
	 * 
	 * @return		the total carbohydrate content in grams
	 */
	public BigDecimal getCarbohydrate() {
		return carbohydrate;
	}
	
	/**
	 * Sets the total carbohydrate content in grams
	 * 
	 * @param		carbohydrate the total carbohydrate content in grams
	 */
	public void setCarbohydrate(BigDecimal carbohydrate) {
		this.carbohydrate = carbohydrate;
	}

	/**
	 * Returns the protein content in grams
	 * 
	 * @return		the protein content in grams
	 */
	public BigDecimal getProtein() {
		return protein;
	}
	
	/**
	 * Sets the protein content in grams
	 * 
	 * @param		protein the protein content in grams
	 */
	public void setProtein(BigDecimal protein) {
		this.protein = protein;
	}

	/**
	 * Returns the fat content in grams
	 * 
	 * @return		the fat content in grams
	 */
	public BigDecimal getFat() {
		return fat;
	}
	
	/**
	 * Sets the fat content in grams
	 * 
	 * @param		fat the fat content in grams
	 */
	public void setFat(BigDecimal fat) {
		this.fat = fat;
	}

	/**
	 * Returns the saturated fat content in grams
	 * 
	 * @return		the saturated fat content in grams
	 */
	public BigDecimal getSaturatedFat() {
		return saturatedFat;
	}
	
	/**
	 * Sets the saturated fat content in grams
	 * 
	 * @param		saturatedFat the saturated fat content in grams
	 */
	public void setSaturatedFat(BigDecimal saturatedFat) {
		this.saturatedFat = saturatedFat;
	}

	/**
	 * Returns the polyunsaturated fat content in grams
	 * 
	 * @return		the polyunsaturated fat content in grams
	 */
	public BigDecimal getPolyunsaturatedFat() {
		return polyunsaturatedFat;
	}
	
	/**
	 * Sets the polyunsaturated fat content in grams
	 * 
	 * @param		polyunsaturatedFat the polyunsaturated fat content in grams
	 */
	public void setPolyunsaturatedFat(BigDecimal polyunsaturatedFat) {
		this.polyunsaturatedFat = polyunsaturatedFat;
	}

	/**
	 * Returns the monounsaturated fat content in grams
	 * 
	 * @return		the monounsaturated fat content in grams
	 */
	public BigDecimal getMonounsaturatedFat() {
		return monounsaturatedFat;
	}
	
	/**
	 * Sets the monounsaturated fat content in grams
	 * 
	 * @param		monounsaturatedFat the monounsaturated fat content in grams
	 */
	public void setMonounsaturatedFat(BigDecimal monounsaturatedFat) {
		this.monounsaturatedFat = monounsaturatedFat;
	}

	/**
	 * Returns the trans fat content in grams
	 * 
	 * @return		the trans fat content in grams
	 */
	public BigDecimal getTransFat() {
		return transFat;
	}
	
	/**
	 * Sets the trans fat content in grams
	 * 
	 * @param		transFat the trans fat content in grams
	 */
	public void setTransFat(BigDecimal transFat) {
		this.transFat = transFat;
	}

	/**
	 * Returns the cholesterol content in milligrams
	 * 
	 * @return		the cholesterol content in milligrams
	 */
	public BigDecimal getCholesterol() {
		return cholesterol;
	}
	
	/**
	 * Sets the cholesterol content in milligrams
	 * 
	 * @param		cholesterol the cholesterol content in milligrams
	 */
	public void setCholesterol(BigDecimal cholesterol) {
		this.cholesterol = cholesterol;
	}

	/**
	 * Returns the sodium content in milligrams
	 * 
	 * @return		the sodium content in milligrams
	 */
	public BigDecimal getSodium() {
		return sodium;
	}
	
	/**
	 * Sets the sodium content in milligrams
	 * 
	 * @param		sodium the sodium content in milligrams
	 */
	public void setSodium(BigDecimal sodium) {
		this.sodium = sodium;
	}

	/**
	 * Returns the potassium content in milligrams
	 * 
	 * @return		the potassium content in milligrams
	 */
	public BigDecimal getPotassium() {
		return potassium;
	}
	
	/**
	 * Sets the potassium content in milligrams
	 * 
	 * @param		potassium the potassium content in milligrams
	 */
	public void setPotassium(BigDecimal potassium) {
		this.potassium = potassium;
	}

	/**
	 * Returns the fiber content in grams
	 * 
	 * @return		the fiber content in grams
	 */
	public BigDecimal getFiber() {
		return fiber;
	}
	
	/**
	 * Sets the fiber content in grams
	 * 
	 * @param		fiber the fiber content in grams
	 */
	public void setFiber(BigDecimal fiber) {
		this.fiber = fiber;
	}

	/**
	 * Returns the sugar content in grams
	 * 
	 * @return		the sugar content in grams
	 */
	public BigDecimal getSugar() {
		return sugar;
	}
	
	/**
	 * Sets the sugar content in grams
	 * 
	 * @param		sugar the sugar content in grams
	 */
	public void setSugar(BigDecimal sugar) {
		this.sugar = sugar;
	}

	/**
	 * Returns the percentage of daily recommended vitamin A
	 * 
	 * @return		the percentage of daily recommended vitamin A
	 */
	public BigDecimal getVitaminA() {
		return vitaminA;
	}
	
	/**
	 * Sets the percentage of daily recommended vitamin A
	 * 
	 * @param		vitaminA the percentage of daily recommended vitamin A
	 */
	public void setVitaminA(BigDecimal vitaminA) {
		this.vitaminA = vitaminA;
	}

	/**
	 * Returns the percentage of daily recommended vitamin C
	 * 
	 * @return		the percentage of daily recommended vitamin C
	 */
	public BigDecimal getVitaminC() {
		return vitaminC;
	}
	
	/**
	 * Sets the percentage of daily recommended vitamin C
	 * 
	 * @param		vitaminC the percentage of daily recommended vitamin C
	 */
	public void setVitaminC(BigDecimal vitaminC) {
		this.vitaminC = vitaminC;
	}

	/**
	 * Returns the percentage of daily recommended calcium
	 * 
	 * @return		the percentage of daily recommended calcium
	 */
	public BigDecimal getCalcium() {
		return calcium;
	}
	
	/**
	 * Sets the percentage of daily recommended calcium
	 * 
	 * @param		calcium the percentage of daily recommended calcium
	 */
	public void setCalcium(BigDecimal calcium) {
		this.calcium = calcium;
	}

	/**
	 * Returns the percentage of daily recommended iron
	 * 
	 * @return		the percentage of daily recommended iron
	 */
	public BigDecimal getIron() {
		return iron;
	}
	
	/**
	 * Sets the percentage of daily recommended iron
	 * 
	 * @param		iron the percentage of daily recommended iron
	 */
	public void setIron(BigDecimal iron) {
		this.iron = iron;
	}
}
