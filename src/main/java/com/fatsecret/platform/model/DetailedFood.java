package com.fatsecret.platform.model;

import java.util.List;

public class DetailedFood extends Food {

  private List<FoodCategory> foodCategories;

  public DetailedFood(Food food, List<FoodCategory> foodCategories) {
    this.brandName = food.brandName;
    this.description = food.description;
    this.id = food.id;
    this.name = food.name;
    this.type = food.type;
    this.url = food.url;
    this.foodCategories = foodCategories;
  }

  public List<FoodCategory> getFoodCategories() {
    return foodCategories;
  }

  public void setFoodCategories(List<FoodCategory> foodCategories) {
    this.foodCategories = foodCategories;
  }
}
