package com.example.phase3.service.Impl;

import com.example.phase3.entity.Order;
import com.example.phase3.exception.AuthenticationNotFoundException;
import com.example.phase3.exception.NullPointerException;
import com.example.phase3.repository.OrderRepository;
import com.example.phase3.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public void saveOrder(Order order) throws NullPointerException {
        if (order == null) {
            throw new NullPointerException();
        }
        orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id) throws AuthenticationNotFoundException {
        Order order = orderRepository.getOrderById(id);
        if (order == null) {
            throw new AuthenticationNotFoundException();
        }
        return order;
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public void updateOrder(long id, Order order) throws NullPointerException {
        Order orderUpdate = orderRepository.getOrderById(id);
        if (order == null) {
            throw new NullPointerException();
        }
        orderUpdate.setFinalPrice(order.getFinalPrice());
    }

    @Override
    public void deleteOrder(Long id) throws AuthenticationNotFoundException {
        Order order = orderRepository.getOrderById(id);
        if (order == null) {
            throw new AuthenticationNotFoundException();
        }
        orderRepository.delete(order);
    }
}
