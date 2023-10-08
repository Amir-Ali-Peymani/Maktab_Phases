package org.example.service;

import org.example.entity.Order;

import java.util.List;

public interface OrderService {

    void saveOrder(Order order);

    Order getOrderById(Long id);

    List<Order> getAllOrder();

    void updateOrder(Order order);

    void deleteOrder(Order order);

}
