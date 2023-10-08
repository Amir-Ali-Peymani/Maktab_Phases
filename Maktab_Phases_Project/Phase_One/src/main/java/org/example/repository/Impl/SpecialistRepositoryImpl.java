package org.example.repository.Impl;

import org.example.base.BaseRepository;
import org.example.entity.Specialist;
import org.example.repository.SpecialistRepository;

import java.util.List;

public class SpecialistRepositoryImpl extends BaseRepository implements SpecialistRepository {
    @Override
    public void saveSpecialist(Specialist specialist) {
        try {
            em.getTransaction().begin();
            em.persist(specialist);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public Specialist getSpecialistById(Long id) {
        return em.find(Specialist.class, id);
    }

    @Override
    public List<Specialist> getAllSpecialists() {
        return em.createQuery("SELECT s FROM Specialist s", Specialist.class).getResultList();
    }

    @Override
    public void updateSpecialist(Specialist specialist) {
        try {
            em.getTransaction().begin();
            em.merge(specialist);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void deleteSpecialist(Specialist specialist) {
        try {
            em.getTransaction().begin();
            em.remove(em.contains(specialist) ? specialist : em.merge(specialist));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
}
