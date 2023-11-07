package com.example.phase3.service;

import com.example.phase3.entity.Customer;
import com.example.phase3.exception.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    void saveCustomer(Customer customer);

    Customer getCustomerByEmailAndPassword(String email, String password) throws AuthenticationException;

    List<Customer> getAllCustomer();

    void updateCustomer(String email, Customer customer);

    void deleteCustomer(long id);
}
