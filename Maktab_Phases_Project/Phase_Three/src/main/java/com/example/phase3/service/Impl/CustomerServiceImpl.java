package com.example.phase3.service.Impl;

import com.example.phase3.dto.CustomerDTO;
import com.example.phase3.entity.*;
import com.example.phase3.enumeration.OrderStatus;
import com.example.phase3.exception.*;
import com.example.phase3.exception.NullPointerException;
import com.example.phase3.repository.*;
import com.example.phase3.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final SubServiceRepository subServiceRepository;

    private final OrderRepository orderRepository;

    private final ProposalRepository proposalRepository;

    private final SpecialistRepository specialistRepository;

    @Override
    public void saveCustomer(Customer customer) throws NullPointerException {
            if (customer == null){
                throw new NullPointerException();
            }
            customerRepository.save(customer);
    }

    @Override
    public void saveCustomerDTO(CustomerDTO customerDTO) throws NullPointerException {
        if (customerDTO == null){
            throw new NullPointerException();
        }
        Customer customer = new Customer();
        if (customerDTO.getId()>0){
            customer = customerRepository.getCustomerById(customerDTO.getId());
        }
        CustomerDTO.toCustomer(customerDTO, customer);
        customerRepository.save(customer);
    }

    @Override
    public CustomerDTO getCustomerByEmailAndPassword(String email, String password) throws AuthenticationNotFoundException,
            InvalidUserNameAndPasswordException {
        if(email == null || email.equals("")  || password == null || password.equals("")){
            throw new InvalidUserNameAndPasswordException();
        }
        Customer customer = customerRepository.findCustomerByEmailAndPassword(email, password);
        if (customer == null) {
            throw new AuthenticationNotFoundException();
        }
        return CustomerDTO.fromCustomer(customer);
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(CustomerDTO::fromCustomer)
                .toList();
    }

    @Override
    public void updateCustomer(String email, Customer customer){
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

    @Override
    public void giveOrder(long id, long subServiceId, Order order) throws NullPointerException {
        Customer customer = customerRepository.getCustomerById(id);
        SubService subService = subServiceRepository.getSubServiceById(subServiceId);
        if (customer == null || subService == null || order == null){
            throw new NullPointerException();
        }
        order.setCustomer(customer);
        order.setSubService(subService);
        order.setOrderStatus(OrderStatus.AWAITING_SPECIALIST_PROPOSAL);
        orderRepository.save(order);
    }

    @Override
    public void selectProposal(long proposalId) throws NullPointerException {
        Proposal proposal = proposalRepository.getProposalById(proposalId);
        Order order = orderRepository.getOrderById(proposal.getOrder().getId());
        Specialist specialist = specialistRepository.getSpecialistById(proposal.getSpecialist().getId());
        if (order == null || specialist == null){
            throw new NullPointerException();
        }
        order.setSpecialist(specialist);
        order.setOrderStatus(OrderStatus.STARTED);
        order.setFinalPrice(proposal.getProposedPrice());
        long millisToAdd = proposal.getDuration() * 24 * 60 * 60 * 1000L;
        order.setCompeletionDate(new Date(proposal.getStartTime().getTime() + millisToAdd));
        orderRepository.save(order);
    }
}
