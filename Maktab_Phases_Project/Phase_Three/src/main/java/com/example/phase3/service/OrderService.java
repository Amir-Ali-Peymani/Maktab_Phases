package com.example.phase3.service;

import com.example.phase3.dto.OrderDTO;
import com.example.phase3.entity.Order;
import com.example.phase3.exception.AuthenticationNotFoundException;
import com.example.phase3.exception.NullPointerException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    void saveOrder(Order order) throws NullPointerException;

    OrderDTO getOrderById(Long id) throws AuthenticationNotFoundException;

    List<OrderDTO> getAllOrder();

    void updateOrder(long id, Order order) throws NullPointerException;

    void deleteOrder(Long id) throws AuthenticationNotFoundException;
}
