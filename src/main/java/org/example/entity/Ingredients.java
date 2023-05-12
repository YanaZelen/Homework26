package org.example.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.dto.FoodType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ingredients", schema = "testbase")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Ingredients {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  @Enumerated(EnumType.STRING)
  private FoodType foodType;

  private int calories;

  @ManyToMany
  private List<Meal> meal;

  public Ingredients(String name, FoodType foodType, int calories) {
    this.name = name;
    this.foodType = foodType;
    this.calories = calories;
  }

  public String toString() {
    return name + " " + foodType + " " + calories + " " + meal;
  }
}
