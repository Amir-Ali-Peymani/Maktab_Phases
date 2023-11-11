package com.example.phase3.service.Impl;

import com.example.phase3.dto.OrderDTO;
import com.example.phase3.entity.Order;
import com.example.phase3.entity.SubService;
import com.example.phase3.enumeration.OrderStatus;
import com.example.phase3.exception.AuthenticationNotFoundException;
import com.example.phase3.exception.NullPointerException;
import com.example.phase3.exception.PriceException;
import com.example.phase3.repository.OrderRepository;
import com.example.phase3.repository.SubServiceRepository;
import com.example.phase3.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final SubServiceRepository subServiceRepository;

    @Override
    public void saveOrder(Order order) throws NullPointerException {
        if (order == null || order.getCustomer() == null) {
            throw new NullPointerException();
        }
        order.setOrderStatus(OrderStatus.AWAITING_SPECIALIST_PROPOSAL);
        SubService subService = subServiceRepository.getSubServiceById(order.getSubService().getId());
        if (order.getProposedPrice() < subService.getBasePrice()){
            orderRepository.save(order);
        }else{
            throw new PriceException();
        }
    }

    @Override
    public OrderDTO getOrderById(Long id) throws AuthenticationNotFoundException {
        Order order = orderRepository.getOrderById(id);
        if (order == null) {
            throw new AuthenticationNotFoundException();
        }
        return OrderDTO.fromOrder(order);
    }

    @Override
    public List<OrderDTO> getAllOrder() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(OrderDTO::fromOrder)
                .toList();
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
