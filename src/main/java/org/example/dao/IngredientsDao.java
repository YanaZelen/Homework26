package org.example.dao;

import org.example.dto.FoodType;
import org.example.entity.Ingredients;

import java.util.List;

public interface IngredientsDao {

    void saveIngredients(String name, FoodType foodType, int calories);

    List<Ingredients> getAllIngredients();

    Ingredients getIngredientsById(long id);

}
