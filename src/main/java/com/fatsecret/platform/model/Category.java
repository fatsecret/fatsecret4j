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
 * This class represents a category that the recipe is classified under.
 *
 * @author Saurabh Rane
 * @version 2.0
 */
public class Category {
	
	/** Name of the Category */
	private String name;

	/** URL for the Category */
	private String url;

	/**
	 * Returns the name of the category
	 * 
	 * @return		name of the category
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the category
	 * 
	 * @param		name the name of the category
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the URL for the category
	 * 
	 * @return		URL for the category
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * Sets the URL for the category
	 * 
	 * @param		url the URL for the category
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
