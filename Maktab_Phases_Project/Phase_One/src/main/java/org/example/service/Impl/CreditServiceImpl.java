package org.example.service.Impl;

import org.example.base.BaseRepository;
import org.example.entity.Credit;
import org.example.repository.CreditRepository;

import java.util.List;

public class CreditServiceImpl extends BaseRepository implements CreditRepository {
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
        return em.find(Credit.class, id);
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
