package Phase_Two.service;

import Phase_Two.entity.Order;
import Phase_Two.entity.SubService;

import java.util.List;

public interface OrderService {


    void saveOrder(Order order);

    Order getOrderById(Long id);

    List<Order> getAllOrder();

    List<Order> getOrderBySubService(SubService subService);

    void updateOrder(Order order);

    void deleteOrder(Order order);
}
