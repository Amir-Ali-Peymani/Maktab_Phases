package Phase_Two.repository;

import Phase_Two.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private SubServiceRepository subServiceRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testCreateOrder(){
        Service service = Service.builder()
                .name("testService")
                .build();
        serviceRepository.save(service);
        SubService subService = SubService.builder()
                .service(service)
                .name("testSubService")
                .basePrice(23444)
                .description("test description")
                .build();
        subServiceRepository.save(subService);
        Customer customer = Customer.builder()
                .firstName("Jones")
                .lastName("peymani")
                .email("peyman@gmail.com")
                .password("23434343")
                .build();
        customerRepository.save(customer);
        Order order = Order.builder()
                .proposedPrice(234342)
                .jobDescription("doing it right, and in short time")
                .date(new Date())
                .customer(customer)
                .subService(subService)
                .orderStatus(OrderStatus.AWAITING_SPECIALIST_PROPOSAL)
                .build();
        orderRepository.save(order);
    }

    @Test
    public void testReadOrder(){
        Order order = orderRepository.findById(1L).orElse(null);
        assertNotNull(order);
        System.out.println("Order Proposed Price: " + order.getProposedPrice()+
                "Order job Description: " + order.getJobDescription()+
                "Order date:  " + order.getDate().getTime());
    }

    @Test
    public void testUpdateOrder(){
        Order order = orderRepository.findById(1L).orElse(null);
        assertNotNull(order);
        order.setProposedPrice(234343);
        assertEquals(234343, order.getProposedPrice());
        orderRepository.save(order);
    }


    @Test
    public void testDeleteOrder(){
        Order order = orderRepository.findById(1L).orElse(null);
        assertNotNull(order);
        orderRepository.delete(order);
    }

}