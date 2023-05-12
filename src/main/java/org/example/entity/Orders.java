package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders", schema = "testbase")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int numberOfOrder;

    @OneToOne
    private CafeTable cafeTable;

    @OneToOne
    private Waiter waiter;

    @OneToMany(mappedBy = "orders")
    private List<Meal> meals;

}