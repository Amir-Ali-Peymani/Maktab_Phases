package org.example.service;

import org.example.entity.Customer;

import java.util.List;

public interface CustomerService {

    void saveCustomer(Customer customer);

    Customer getCustomerById(Long id);

    List<Customer> getAllCustomer();

    void updateCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}
