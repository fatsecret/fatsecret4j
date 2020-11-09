package com.fatsecret.platform.services;

import com.fatsecret.platform.model.CompactFood;
import org.junit.Before;
import org.junit.Test;

import com.fatsecret.platform.model.Food;

import java.util.List;

import static org.junit.Assert.*;

public class FoodServiceTest {
    private FatsecretService service;

    @Before
    public void setUp() {
        String key = "your key";
        String secret = "your secret";

        service = new FatsecretService(key, secret);
    }

    @Test
    public void testGetFood() {
        Food food = service.getFood(285243L);
        assertEquals("Penne", food.getName());
        assertEquals(4, food.getServings().size());
        assertEquals("Generic", food.getType());
    }

    @Test
    public void testGetFoodTypeGeneric() {
        Food food = service.getFood(285243L);
        assertEquals("Generic", food.getType());
    }

    @Test
    public void testGetFoodTypeBrand() {
        Food food = service.getFood(1844450L);
        assertEquals("Brand", food.getType());
    }

    @Test
    public void brandNameIsSetForFoodSearch() {
        List<CompactFood> results = service.searchFoods("toast").getResults();

        int resultCountWithTypeBrand = 0;
        for (CompactFood food : results) {
            if (food.getType().equals("Brand")) {
                resultCountWithTypeBrand++;
                assertNotNull(food.getBrandName());
            }
        }

        assertTrue(resultCountWithTypeBrand > 0);
    }
}
