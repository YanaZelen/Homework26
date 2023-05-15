package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@javax.persistence.Table(name = "cafetable", schema = "testbase")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CafeTable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Integer numberOfTable;

  @OneToOne
  private Orders orders;

}
