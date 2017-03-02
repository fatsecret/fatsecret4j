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

import java.util.List;

/**
 * This class represents detailed information about the food item.
 *
 * @author Saurabh Rane
 * @version 2.0
 */
public class Food extends CompactFood {

	/** A list of all servings for this food */
	private List<Serving> servings;
	
	/**
	 * Returns the list of all servings for this food
	 * 
	 * @return		the list of all servings for this food
	 */
	public List<Serving> getServings() {
		return servings;
	}
	
	/**
	 * Sets the list of all servings for this food
	 * 
	 * @param		servings the list of all servings for this food
	 */
	public void setServings(List<Serving> servings) {
		this.servings = servings;
	}
}
