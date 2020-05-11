package com.fatsecret.platform.utils;

import com.fatsecret.platform.model.FoodSubCategory;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class FoodSubCategoryUtility {

  /**
   * Returns a list of food sub categories.
   *
   * @param array json array representing a list of food sub categories
   * @return list of food sub categories
   */
  public static List<FoodSubCategory> parseFoodSubCategoryListFromJSONArray(JSONArray array) {
    List<FoodSubCategory> foodSubCategories = new LinkedList<>();
    for (int i = 0; i < array.length(); i++) {
      String name = array.getString(i);
      FoodSubCategory foodSubCategory = new FoodSubCategory(name);
      foodSubCategories.add(foodSubCategory);
    }
    return foodSubCategories;
  }

}
