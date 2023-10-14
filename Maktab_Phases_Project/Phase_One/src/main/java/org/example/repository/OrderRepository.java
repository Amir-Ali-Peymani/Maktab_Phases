package org.example.repository;

import org.example.entity.Customer;
import org.example.entity.Order;
import org.example.entity.SubService;

import java.util.List;

public interface OrderRepository {

    void saveOrder(Order order);

    Order getOrderById(Long id);

    List<Order> getAllOrder();

    List<Order> getOrderBySubService(SubService subService);

    void updateOrder(Order order);

    void deleteOrder(Order order);

}
