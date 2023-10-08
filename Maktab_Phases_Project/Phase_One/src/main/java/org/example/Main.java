package org.example;

import org.example.base.BaseRepository;
import org.example.entity.Customer;
import org.example.entity.Order;
import org.example.service.Impl.CustomerServiceImpl;
import org.example.service.OrderService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main extends BaseRepository {
    public static void main(String[] args) {
        // Create a Customer instance
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("john.doe@example.com");
        customer.setPassword("password123");

        // Create an Order instance
        Order order = new Order();
        order.setProposedPrice(100.0); // Set other order properties as needed
        order.setCustomer(customer); // Set the customer for this order

        // Now, add the order to the customer's set of orders
        Set<Order> orders = new HashSet<>();
        orders.add(order);
        customer.setOrders(orders);

        // Save the customer and order to the database using your service
        // OrderService orderService = new OrderService();
        // orderService.saveCustomer(customer);
        // orderService.saveOrder(order);
    }
}
