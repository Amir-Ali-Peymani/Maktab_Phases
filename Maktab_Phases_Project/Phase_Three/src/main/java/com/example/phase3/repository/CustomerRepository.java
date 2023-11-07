package com.example.phase3.repository;

import com.example.phase3.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerByEmailAndPassword(String email, String password);

    Customer findCustomerByEmail(String email);

    Customer getCustomerById(Long id);
}
