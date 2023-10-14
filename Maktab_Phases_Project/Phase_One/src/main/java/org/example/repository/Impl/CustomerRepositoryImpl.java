package org.example.repository.Impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.base.BaseRepository;
import org.example.entity.Customer;
import org.example.repository.CustomerRepository;

import java.util.List;

public class CustomerRepositoryImpl extends BaseRepository implements CustomerRepository {


    @Override
    public void saveCustomer(Customer customer) {
        try {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public Customer getCustomerById(Long id) {
        try {
            Customer customer = em.find(Customer.class, id);
            if (customer == null) {
                throw new EntityNotFoundException("Customer not found with id: " + id);
            }
            return customer;
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Customer not found with id: "+ id);
        }

    }

    @Override
    public List<Customer> getAllCustomer() {
        return em.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
    }

    @Override
    public void updateCustomer(Customer customer) {
        try {
            em.getTransaction().begin();
            em.merge(customer);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void deleteCustomer(Customer customer) {
        try {
            em.getTransaction().begin();
            em.remove(em.contains(customer) ? customer : em.merge(customer));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
}
