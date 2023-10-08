package org.example.repository.Impl;

import org.example.base.BaseRepository;
import org.example.entity.Admin;
import org.example.repository.AdminRepository;

public class AdminRepositoryImpl extends BaseRepository implements AdminRepository {
    @Override
    public Admin getAdminById(long id) {
        return em.find(Admin.class, id);
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
