package org.example.repository.Impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.base.BaseRepository;
import org.example.entity.Credit;
import org.example.repository.CreditRepository;

import java.util.List;

public class CreditRepositoryImpl extends BaseRepository implements CreditRepository {
    @Override
    public void saveCredit(Credit credit) {
        try {
            em.getTransaction().begin();
            em.persist(credit);
            em.getTransaction().commit();
        }catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public Credit getCreditById(Long id) {
        try {
            Credit credit = em.find(Credit.class, id);
            if (credit == null) {
                throw new EntityNotFoundException("Credit not found with id: " + id);
            }
            return credit;
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Credit not found with id: " + id);
        }

    }

    @Override
    public List<Credit> getAllCredit() {
        return em.createQuery("SELECT c FROM Credit c", Credit.class).getResultList();
    }

    @Override
    public void updateCredit(Credit credit) {
        try {
            em.getTransaction().begin();
            em.merge(credit);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void deleteCredit(Credit credit) {
        try {
            em.getTransaction().begin();
            em.remove(em.contains(credit) ? credit : em.merge(credit));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
}
