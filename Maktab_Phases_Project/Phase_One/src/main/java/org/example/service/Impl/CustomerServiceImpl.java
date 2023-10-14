package org.example.service.Impl;

import org.example.entity.Customer;
import org.example.repository.CustomerRepository;
import org.example.service.CustomerService;
import org.example.util.ServiceLocator;
import org.example.util.Validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void saveCustomer(Customer customer) {
        boolean isEmailValid = Validation.isValidEmail(customer.getEmail());
        boolean isPasswordValid = Validation.isValidPassword(customer.getPassword());

        if (!isEmailValid && !isPasswordValid) {
            System.out.println("Email and password are not valid. Information not saved.");
        } else if (!isEmailValid) {
            System.out.println("Email is not valid. Information not saved.");
        } else if (!isPasswordValid) {
            System.out.println("Password is not valid. Information not saved.");
        } else {
            Set<String> addedCustomer = new HashSet<>();
            List<Customer> customerList = ServiceLocator.getCustomerService().getAllCustomer();

            for (Customer customerLoop : customerList) {
                addedCustomer.add(customerLoop.getEmail());
            }

            if (addedCustomer.contains(customer.getEmail())) {
                System.out.println("This customer already exists. Information not saved.");
            } else {
                customerRepository.saveCustomer(customer);
                System.out.println("Customer added to the database.");
            }
        }
    }


    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.getAllCustomer();
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.updateCustomer(customer);
        System.out.println("Updated customer");
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customerRepository.deleteCustomer(customer);
    }
}
