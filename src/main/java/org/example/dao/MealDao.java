package org.example.dao;

import org.example.entity.Meal;

import java.util.List;

public interface MealDao {

    void saveMeal(String name);

    List<Meal> getAllMeal();

    Meal getMealById(long id);

}
