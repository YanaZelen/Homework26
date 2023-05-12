package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Setter
public class CafeTable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Integer numberOfTable;

  @OneToOne
  private CafeOrder cafeOrder;

  public CafeTable(Integer numberOfTable) {
    this.numberOfTable = numberOfTable;
  }

  public String toString() {
    return numberOfTable + " " + cafeOrder;
  }

}
