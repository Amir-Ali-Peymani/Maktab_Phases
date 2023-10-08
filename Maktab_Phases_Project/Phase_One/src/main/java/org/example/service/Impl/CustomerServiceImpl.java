package org.example.service.Impl;

import org.example.base.BaseRepository;
import org.example.entity.Customer;
import org.example.repository.CustomerRepository;

import java.util.List;

public class CustomerServiceImpl extends BaseRepository implements CustomerRepository {


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
        return em.find(Customer.class, id);
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
