package org.example.service.Impl;

import org.example.entity.Customer;
import org.example.entity.Order;
import org.example.entity.OrderStatus;
import org.example.entity.SubService;
import org.example.repository.OrderRepository;
import org.example.service.OrderService;
import org.example.util.ServiceLocator;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void saveOrder(Order order) {
        if (order.getSpecialist() == null) {
            order.setOrderStatus(OrderStatus.AWAITING_SPECIALIST_PROPOSAL);
        }
        List<Order> orders = getAllOrder();

        for (Order orderLoop : orders) {
            if (orderLoop.equals(order)) {
                System.out.println("this order is already exist");
            } else if (order.getSubService().getBasePrice() >= order.getProposedPrice()){
                orderRepository.saveOrder(order);
                System.out.println("order is saved");
            } else {
                System.out.println("the proposed price is more than a sub-service price");
            }
        }
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
    public List<Order> getOrderBySubService(SubService subService) {
        return orderRepository.getOrderBySubService(subService);
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
