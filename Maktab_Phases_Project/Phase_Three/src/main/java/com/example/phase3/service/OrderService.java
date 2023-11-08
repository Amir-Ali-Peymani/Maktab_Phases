package com.example.phase3.service;

import com.example.phase3.entity.Order;
import com.example.phase3.exception.AuthenticationNotFoundException;
import com.example.phase3.exception.NullPointerException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    void saveOrder(Order order) throws NullPointerException;

    Order getOrderById(Long id) throws AuthenticationNotFoundException;

    List<Order> getAllOrder();

    void updateOrder(long id, Order order) throws NullPointerException;

    void deleteOrder(Long id) throws AuthenticationNotFoundException;
}
