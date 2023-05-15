package org.example.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "meal", schema = "testbase")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Meal {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  @ManyToMany(mappedBy = "meal")
  private List<Ingredients> ingredients;

  @ManyToOne
  private Orders orders;

}
