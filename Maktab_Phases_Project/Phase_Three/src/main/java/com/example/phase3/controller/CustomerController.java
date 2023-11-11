package com.example.phase3.controller;


import com.example.phase3.dto.CustomerDTO;
import com.example.phase3.entity.Customer;
import com.example.phase3.entity.Order;
import com.example.phase3.exception.*;
import com.example.phase3.exception.NullPointerException;
import com.example.phase3.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/saveCustomer")
    public void saveCustomer(@RequestBody Customer customer) throws NullPointerException {
        customerService.saveCustomer(customer);
    }

    @PostMapping("/customerGiveOrder/{id}/{subServiceId}")
    public void customerGiveOrder(@PathVariable("id") long id, @PathVariable("subServiceId")
                                  long subServiceId, @RequestBody Order order){
        customerService.giveOrder(id, subServiceId, order);
    }

    @PostMapping("/customerChooseProposal/{id}")
    public void customerChooseProposal(@PathVariable("id")long id){
        customerService.selectProposal(id);
    }


    @GetMapping("/login/{email}/{password}")
    public ResponseEntity<?> customerLoginIn(@PathVariable("email") String email,
                                             @PathVariable("password") String password){
        try {
            CustomerDTO customerDTO = customerService.getCustomerByEmailAndPassword(email, password);
            return ResponseEntity.ok(customerDTO);
        }catch (InvalidUserNameAndPasswordException e) {
            throw new RuntimeException(e);
        } catch (BaseHttpException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

    @GetMapping("/getAllCustomer")
    public ResponseEntity<?> getAllCustomer(){
        try {
            List<CustomerDTO> customersDTO = customerService.getAllCustomer();
            return ResponseEntity.ok(customersDTO);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/updateCustomer/{email}")
    public void updateCustomer(@PathVariable("email") String email,
                               @RequestBody Customer customer) throws NullPointerException, InvalidEmailException {
        customerService.updateCustomer(email, customer);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public void deleteCustomer(@PathVariable("id") Long id) throws AuthenticationNotFoundException, InvalidIdException {
        customerService.deleteCustomer(id);
    }

}
