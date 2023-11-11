package com.example.phase3.service;

import com.example.phase3.dto.CustomerDTO;
import com.example.phase3.entity.Customer;
import com.example.phase3.entity.Order;
import com.example.phase3.exception.*;
import com.example.phase3.exception.NullPointerException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    void saveCustomer(Customer customer) throws NullPointerException;

    CustomerDTO getCustomerByEmailAndPassword(String email, String password) throws AuthenticationException, InvalidUserNameAndPasswordException;

    List<CustomerDTO> getAllCustomer();

    void updateCustomer(String email, Customer customer) throws InvalidEmailException, NullPointerException;

    void deleteCustomer(long id) throws InvalidIdException, AuthenticationNotFoundException;

    void giveOrder(long id, long subServiceId, Order order);

    void selectProposal(long proposalId);
}
