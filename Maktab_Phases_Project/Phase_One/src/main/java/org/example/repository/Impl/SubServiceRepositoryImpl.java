package org.example.repository.Impl;

import org.example.base.BaseRepository;
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
        return em.find(SubService.class, id);
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
