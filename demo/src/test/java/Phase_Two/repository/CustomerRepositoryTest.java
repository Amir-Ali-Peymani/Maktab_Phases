package Phase_Two.repository;

import Phase_Two.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProposalRepository proposalRepository;

    @Test
    public void testCreateCustomer(){
        Customer customer = Customer.builder()
                .firstName("amirali")
                .lastName("peymani")
                .email("peymani@gmail.com")
                .password("password")
                .build();
        customerRepository.save(customer);
    }


    @Test
    public void testReadProposal(){
        Customer customer = customerRepository.findCustomerByEmailAndPassword("password", "password");
        Set<Order> orders = customer.getOrders();
        for(Order order : orders){
            System.out.println("Order Id: " + order.getId()+ "Order subService" + order.getSubService().getName());
        }
        Order order = orderRepository.findById(2L).orElse(null);
        assertNotNull(order);
        List<Proposal> proposals = order.getProposals();
        for (Proposal proposal : proposals) {
            System.out.println("proposal Id: " + proposal.getId()+ "proposal price: " +proposal.getProposedPrice()+
                    "proposal specialist: " + proposal.getSpecialist().getFirstName()+
            "specialist id: " + proposal.getSpecialist().getId());
        }
        Proposal proposal = proposalRepository.findById(1L).orElse(null);
        assertNotNull(proposal);
        order.setSpecialist(proposal.getSpecialist());
        order.setOrderStatus(OrderStatus.STARTED);
        order.setFinalPrice(proposal.getProposedPrice());
        orderRepository.save(order);
    }


    @Test
    public void testReadCustomer(){
        Customer customer = customerRepository.findById(1L).orElse(null);
        assertNotNull(customer);
        System.out.println("Customer name: "+ customer.getFirstName()+
                "Customer last name: "+ customer.getLastName()+
                "Customer email: "+ customer.getEmail()
        );
    }

    @Test
    public void testUpdateCustomer(){
        Customer customer = customerRepository.findById(1L).orElse(null);
        assertNotNull(customer);
        customer.setFirstName("John");
        assertEquals("John", customer.getFirstName());
        customerRepository.save(customer);
    }

    @Test
    public void testDeleteCustomer(){
        Customer customer = customerRepository.findById(1L).orElse(null);
        assertNotNull(customer);
        customerRepository.delete(customer);
    }
}