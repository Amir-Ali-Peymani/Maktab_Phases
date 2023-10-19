package com.example.demo.repository;

import com.example.demo.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

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