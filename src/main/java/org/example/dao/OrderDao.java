package org.example.dao;

import org.example.entity.CafeOrder;

import java.util.List;

public interface OrderDao {

    void saveOrder(Integer numberOfOrder);

    List<CafeOrder> getAllOrder();

    CafeOrder getOrderById(long id);

}
