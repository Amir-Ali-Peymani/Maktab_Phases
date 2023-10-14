package org.example.repository.Impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NoResultException;
import org.example.base.BaseRepository;
import org.example.entity.Service;
import org.example.entity.SubService;
import org.example.repository.SubServiceRepository;

import java.util.List;

public class SubServiceRepositoryImpl extends BaseRepository implements SubServiceRepository {
    @Override
    public void saveSubService(SubService subService) {
        try {
            em.getTransaction().begin();
            em.persist(subService);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public SubService getSubServiceById(Long id) {
        try {
            SubService subService = em.find(SubService.class, id);
            if (subService == null) {
                throw new EntityNotFoundException("SubService not found with id: " + id);
            }
            return subService;
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException(("subService not found" + id));
        }
    }

    @Override
    public SubService getSubServiceByName(String name) {
        try {
            return em.createQuery("SELECT s FROM SubService s WHERE s.name = :name", SubService.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException e) {
            throw new EntityNotFoundException("SubService not found with name: " + name);
        }
    }

    @Override
    public List<SubService> getAllSubServices() {
        return em.createQuery("SELECT s FROM SubService  s", SubService.class).getResultList();
    }

    @Override
    public void updateSubService(SubService subService) {
        try {
            em.getTransaction().begin();
            em.merge(subService);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void deleteSubService(SubService subService) {
        try {
            em.getTransaction().begin();
            em.remove(em.contains(subService) ? subService : em.merge(subService));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
}
