package org.example.repository.Impl;

import jakarta.persistence.TypedQuery;
import org.example.base.BaseRepository;
import org.example.entity.Customer;
import org.example.entity.Order;
import org.example.entity.SubService;
import org.example.repository.OrderRepository;

import java.util.List;

public class OrderRepositoryImpl extends BaseRepository implements OrderRepository {
    @Override
    public void saveOrder(Order order) {
        try {
            em.getTransaction().begin();
            em.persist(order);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public Order getOrderById(Long id) {
        return em.find(Order.class, id);
    }

    @Override
    public List<Order> getAllOrder() {
        return em.createQuery("SELECT o FROM Order o", Order.class).getResultList();
    }

    @Override
    public List<Order> getOrdersByCustomerAndSubService(Customer customer, SubService subService) {
        String jpql = "SELECT o FROM Order o WHERE o.customer = :customer AND o.subService = :subService";
        TypedQuery<Order> query = em.createQuery(jpql, Order.class);
        query.setParameter("customer", customer);
        query.setParameter("subService", subService);
        return query.getResultList();
    }

    @Override
    public void updateOrder(Order order) {
        try {
            em.getTransaction().begin();
            em.merge(order);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void deleteOrder(Order order) {
        try {
            em.getTransaction().begin();
            em.remove(em.contains(order) ? order: em.merge(order));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
}
