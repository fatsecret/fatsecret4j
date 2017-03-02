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

import java.util.List;

/**
 * This class represents the response from the request sent to the fatsecret rest api
 * @param <E> the type of elements held in the list in this response
 *
 * @author Saurabh Rane
 * @version 2.0
 */
public class Response<E> {
	
	/** The zero-based offset into the results for the query */
	private int pageNumber;

	/** The maximum number of results */
	private int maxResults;
	
	/** The total number of results */
	private int totalResults;
	
	/** The list of elements */
	private List<E> results;
	
	/**
	 * Returns the zero-based offset into the results for the query
	 * 
	 * @return		the zero-based offset into the results for the query
	 */
	public int getPageNumber() {
		return pageNumber;
	}
	
	/**
	 * Sets the zero-based offset into the results for the query
	 * 
	 * @param		pageNumber the zero-based offset into the results for the query
	 */
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * Returns the maximum size of a page of results
	 * 
	 * @return		the maximum size of a page of results
	 */
	public int getMaxResults() {
		return maxResults;
	}
	
	/**
	 * Sets the maximum size of a page of results.
	 * 
	 * @param		maxResults the maximum size of a page of results.
	 */
	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	/**
	 * Returns the total number of search results matching the search expression
	 * 
	 * @return		the total number of search results matching the search expression
	 */
	public int getTotalResults() {
		return totalResults;
	}
	
	/**
	 * Sets the total number of search results matching the search expression
	 * 
	 * @param		totalResults the total number of search results matching the search expression
	 */
	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}

	/**
	 * Returns the list of the results
	 * 
	 * @return		the list of the results
	 */
	public List<E> getResults() {
		return results;
	}
	
	/**
	 * Sets the list of the results
	 * 
	 * @param		results the list of the results
	 */
	public void setResults(List<E> results) {
		this.results = results;	
	}
}