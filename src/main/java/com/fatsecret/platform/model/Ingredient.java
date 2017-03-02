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
 * This class represents detailed information about the ingredient
 *
 * @author Saurabh Rane
 * @version 2.0
 */
public class Ingredient {
	
	/** The unique food identifier */
	private Long foodId;

	/** The unique serving identifier */
	private Long servingId;
	
	/** The fully formated description of the ingredient */
	private String description;

	/** The name of the food, not including the brand name */
	private String name;
	
	/** URL of this ingredient on <a href="http://www.fatsecret.com">Fatsecret website</a> */
	private String url;

	/** The number of units of this ingredient used in the recipe */
	private BigDecimal numberOfUnits;

	/** The unit of measure of this ingredient used in the recipe - E.G.: "cup" or "g" */
	private String measurementDescription;

	/**
	 * Returns the unique food identifier
	 * 
	 * @return		the unique food identifier
	 */
	public Long getFoodId() {
		return foodId;
	}
	
	/**
	 * Sets the unique food identifier
	 * 
	 * @param		foodId the unique food identifier
	 */
	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}

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
	 * Returns the fully formated description of the ingredient
	 * 
	 * @return		the fully formated description of the ingredient
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the fully formated description of the ingredient
	 * 
	 * @param		description the fully formated description of the ingredient
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Returns the name of the food
	 * 
	 * @return		the name of the food
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the food
	 * 
	 * @param		name the name of the food
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the URL of the ingredient
	 * 
	 * @return		the URL for the ingredient
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * Sets the URL for the ingredient
	 * 
	 * @param		url the URL for the ingredient
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * Returns the number of units of this ingredient used in the recipe
	 * 
	 * @return		the number of units of this ingredient used in the recipe
	 */
	public BigDecimal getNumberOfUnits() {
		return numberOfUnits;
	}
	
	/**
	 * Sets the number of units of this ingredient used in the recipe
	 * 
	 * @param		numberOfUnits the number of units of this ingredient used in the recipe
	 */
	public void setNumberOfUnits(BigDecimal numberOfUnits) {
		this.numberOfUnits = numberOfUnits;
	}

	/**
	 * Returns the unit of measure of this ingredient
	 * 
	 * @return		the unit of measure of this ingredient
	 */
	public String getMeasurementDescription() {
		return measurementDescription;
	}
	
	/**
	 * Sets the unit of measure of this ingredient
	 * 
	 * @param		measurementDescription the unit of measure of this ingredient
	 */
	public void setMeasurementDescription(String measurementDescription) {
		this.measurementDescription = measurementDescription;
	}
}
