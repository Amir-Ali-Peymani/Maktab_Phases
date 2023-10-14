package org.example.repository.Impl;

import jakarta.persistence.EntityNotFoundException;
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
        try{
            Order order = em.find(Order.class, id);
            if (order == null){
                throw new EntityNotFoundException("Order not found with id:"+ id);
            }
            return order;
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Order not found with id: "+ id);
        }
    }

    @Override
    public List<Order> getAllOrder() {
        return em.createQuery("SELECT o FROM Order o", Order.class).getResultList();
    }

    @Override
    public List<Order> getOrderBySubService(SubService subService) {
        String jpql = "SELECT o FROM Order o WHERE o.subService = :subService";
        TypedQuery<Order> query = em.createQuery(jpql, Order.class);
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
