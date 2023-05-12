package org.example.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "meal", schema = "testbase")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Meal {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  @ManyToMany(mappedBy = "meal")
  private List<Ingredients> ingredients;

  public Meal(String name) {
    this.name = name;
  }

  public String toString() {
    return name + " " + ingredients;
  }
}
