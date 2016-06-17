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

/**
 * This class represents summary information about the food item.
 *
 * @author Saurabh Rane
 * @version 1.0
 */
public class CompactFood {

	/** Name of the food, not including the brand name */
	protected String name;

	/** URL of this food item on <a href="http://www.fatsecret.com">Fatsecret website</a> */
	protected String url;

	/** Type of the food - indicates whether the food is a brand or generic item */
	protected String type;

	/** The unique food identifier */
	protected Long id;

	/** A short description of the food */
	protected String description;

	/** The brand name, only when food_type is "Brand" */
	protected String brandName;
	
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
	 * Returns the URL for the food
	 * 
	 * @return		the URL for the food
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * Sets the URL for the food
	 * 
	 * @param		url the URL for the food
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Returns the type of the food
	 * 
	 * @return		the type of the food
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Sets the type of the food
	 * 
	 * @param		type the type of the food
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Returns the unique food identifier
	 * 
	 * @return		the unique food identifier
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Sets the unique food identifier
	 * 
	 * @param		id the unique food identifier
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the short description of the food
	 * 
	 * @return		the short description of the food
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the short description of the food
	 * 
	 * @param		description the short description of the food
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the brand name of the food
	 * 
	 * @return		the brand name of the food
	 */
	public String getBrandName() {
		return brandName;
	}
	
	/**
	 * Sets the brand name of the food
	 * 
	 * @param		brandName the brand name of the food
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
}
