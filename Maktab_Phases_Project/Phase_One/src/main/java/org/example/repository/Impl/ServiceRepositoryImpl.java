package org.example.repository.Impl;

import jakarta.persistence.NoResultException;
import org.example.base.BaseRepository;
import org.example.entity.Service;
import org.example.repository.ServiceRepository;

import java.util.List;

public class ServiceRepositoryImpl extends BaseRepository implements ServiceRepository {
    @Override
    public void saveService(Service service) {
        try {
            em.getTransaction().begin();
            em.persist(service);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public Service getServiceById(Long id) {
        return em.find(Service.class, id);
    }

    @Override
    public Service getServiceByName(String name) {
        try {
            return em.createQuery("SELECT s FROM Service s WHERE s.name = :name", Service.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }


    @Override
    public List<Service> getAllServices() {
        return em.createQuery("SELECT s FROM Service  s", Service.class).getResultList();
    }

    @Override
    public void updateService(Service service) {
        try {
            em.getTransaction().begin();
            em.merge(service);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void deleteService(Service service) {
        try {
            em.getTransaction().begin();
            em.remove(em.contains(service) ? service : em.merge(service));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
}
