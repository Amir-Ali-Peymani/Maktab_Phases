package org.example.base;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.Admin;
import org.example.repository.AdminRepository;
import org.example.repository.Impl.AdminRepositoryImpl;
import org.example.service.AdminService;
import org.example.service.Impl.AdminServiceImpl;

public class BaseRepository {

    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    protected static EntityManager em = emf.createEntityManager();

    protected static final AdminRepository adminRepository = new AdminRepositoryImpl();

    protected static final AdminService adminService = new AdminServiceImpl(adminRepository);

}
