package org.example.repository.Impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.base.BaseRepository;
import org.example.entity.Admin;
import org.example.entity.Credit;
import org.example.repository.AdminRepository;

import java.util.List;

public class AdminRepositoryImpl extends BaseRepository implements AdminRepository {
    @Override
    public Admin getAdminById(long id) {
        try {
            Admin admin = em.find(Admin.class, id);
            if (admin == null) {
                throw new EntityNotFoundException("Admin not found with id: " + id);
            }
            return admin;
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Admin not found with id: " + id);
        }
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
