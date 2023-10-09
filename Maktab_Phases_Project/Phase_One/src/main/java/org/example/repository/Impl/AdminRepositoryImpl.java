package org.example.repository.Impl;

import org.example.base.BaseRepository;
import org.example.entity.Admin;
import org.example.entity.Credit;
import org.example.repository.AdminRepository;

import java.util.List;

public class AdminRepositoryImpl extends BaseRepository implements AdminRepository {
    @Override
    public Admin getAdminById(long id) {
        return em.find(Admin.class, id);
    }

    @Override
    public List<Admin> getAllAdmin() {
        return em.createQuery("SELECT a FROM Admin a", Admin.class).getResultList();
    }

    @Override
    public void updateAdmin(Admin admin) {
        try {
            em.getTransaction().begin();
            em.merge(admin);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
}
