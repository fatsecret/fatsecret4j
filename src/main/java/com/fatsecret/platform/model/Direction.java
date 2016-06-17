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
 * @version 1.0
 */
public class Direction {
	
	/** The order of this step */
	private Integer number;

	/** The instruction of this step */
	private String description;

	/**
	 * Returns the order of this step
	 * 
	 * @return		the order of this step
	 */
	public Integer getNumber() {
		return number;
	}
	
	/**
	 * Sets the order of this step
	 * 
	 * @param		number the order of this step
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	/**
	 * Returns the instruction of this step
	 * 
	 * @return		the instruction of this step
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the instruction of this step
	 * 
	 * @param		description the instruction of this step
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
