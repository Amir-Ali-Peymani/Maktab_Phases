package com.example.phase3.service.Impl;

import com.example.phase3.entity.Customer;
import com.example.phase3.exception.*;
import com.example.phase3.exception.NullPointerException;
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
    public void saveCustomer(Customer customer) throws NullPointerException {
            if (customer == null){
                throw new NullPointerException();
            }
            customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerByEmailAndPassword(String email, String password) throws AuthenticationNotFoundException,
            InvalidUserNameAndPasswordException {
        if(email == null || email.equals("")  || password == null || password.equals("")){
            throw new InvalidUserNameAndPasswordException();
        }
        Customer customer = customerRepository.findCustomerByEmailAndPassword(email, password);
        if (customer == null) {
            throw new AuthenticationNotFoundException();
        }
        return customer;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public void updateCustomer(String email, Customer customer) throws InvalidEmailException, NullPointerException {
        if (email == null || email.equals("")) {
            throw new InvalidEmailException();
        }
        Customer customerUpdate = customerRepository.findCustomerByEmail(email);
        if (customer == null) {
            throw new NullPointerException();
        }
        customerUpdate.setEmail(customer.getEmail());
        customerUpdate.setPassword(customer.getPassword());
        customerRepository.save(customerUpdate);
    }

    @Override
    public void deleteCustomer(long id) throws AuthenticationNotFoundException {
        Customer customer = customerRepository.getCustomerById(id);
        if (customer == null){
            throw new AuthenticationNotFoundException();
        }
        customerRepository.delete(customer);
    }
}
