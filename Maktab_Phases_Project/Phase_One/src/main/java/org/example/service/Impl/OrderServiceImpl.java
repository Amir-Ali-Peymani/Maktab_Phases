package org.example.service.Impl;

import org.example.entity.Customer;
import org.example.entity.Order;
import org.example.entity.SubService;
import org.example.repository.OrderRepository;
import org.example.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.saveOrder(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.getOrderById(id);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.getAllOrder();
    }

    @Override
    public List<Order> getOrdersByCustomerAndSubService(Customer customer, SubService subService) {
        return orderRepository.getOrdersByCustomerAndSubService(customer, subService);
    }

    @Override
    public void updateOrder(Order order) {
        orderRepository.updateOrder(order);
    }

    @Override
    public void deleteOrder(Order order) {
        orderRepository.deleteOrder(order);
    }
}
