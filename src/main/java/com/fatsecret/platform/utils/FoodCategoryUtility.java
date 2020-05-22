package com.fatsecret.platform.utils;

import com.fatsecret.platform.model.FoodCategory;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class FoodCategoryUtility {

  /**
   * Returns a list of food categories.
   *
   * @param array json array representing a list of food categories
   * @return list of food categories
   */
  public static List<FoodCategory> parseFoodCategoryListFromJSONArray(JSONArray array) {
    List<FoodCategory> foodCategories = new LinkedList<>();
    for (int i = 0; i < array.length(); i++) {
      JSONObject jsonObject = array.getJSONObject(i);
      FoodCategory foodCategory = parseFoodCategoryFromJSONObject(jsonObject);
      foodCategories.add(foodCategory);
    }
    return foodCategories;
  }

  /**
   * Returns information about the food category.
   *
   * @param object json object representing the food category
   * @return food category
   */
  private static FoodCategory parseFoodCategoryFromJSONObject(JSONObject object) {
    long id = Long.parseLong(
        Objects.requireNonNull(JsonUtility.getPropertyValue(object, "food_category_id")));
    String name = JsonUtility.getPropertyValue(object, "food_category_name");
    String description = JsonUtility.getPropertyValue(object, "food_category_description");
    return new FoodCategory(id, name, description);
  }

}
