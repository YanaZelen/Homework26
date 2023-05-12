package org.example.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "waiter", schema = "testbase")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Waiter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String lastName;

    @OneToOne
    private CafeOrder cafeOrder;

    public Waiter(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String toString() {
        return name + " " + lastName + " " + cafeOrder;
    }
}
