package org.example.dao;

import java.util.List;
import org.example.entity.Waiter;

public interface WaiterDao {

    void saveWaiter(String name, String lastName);

    List<Waiter> getAllWaiter();

    Waiter getWaiterById(long id);

}
