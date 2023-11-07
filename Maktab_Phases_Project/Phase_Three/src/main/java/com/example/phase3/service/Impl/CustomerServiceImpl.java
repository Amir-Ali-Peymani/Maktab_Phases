package com.example.phase3.service.Impl;

import com.example.phase3.entity.Customer;
import com.example.phase3.exception.AuthenticationException;
import com.example.phase3.repository.CustomerRepository;
import com.example.phase3.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public void saveCustomer(Customer customer) {
            customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerByEmailAndPassword(String email, String password) throws AuthenticationException {
        Customer customer = customerRepository.findCustomerByEmailAndPassword(email, password);
        if (customer == null) {
            throw new AuthenticationException("Could not find customer");
        }
        return customer;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public void updateCustomer(String email, Customer customer) {
        Customer customerUpdate = customerRepository.findCustomerByEmail(email);
        customerUpdate.setPassword(customer.getPassword());
        customerUpdate.setEmail(customer.getEmail());
        customerRepository.save(customerUpdate);
    }

    @Override
    public void deleteCustomer(long id){
        Customer customer = customerRepository.getCustomerById(id);
        customerRepository.delete(customer);
    }
}
