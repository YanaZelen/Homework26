package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cafeorder", schema = "testbase")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class CafeOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int numberOfOrder;

    @OneToOne
    private CafeTable cafeTable;

    @OneToOne
    private Waiter waiter;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<Meal> meals;

    public CafeOrder(int numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }

    public String toString() {
        return numberOfOrder + " " + cafeTable + " " + waiter + " " + meals;
    }
}
