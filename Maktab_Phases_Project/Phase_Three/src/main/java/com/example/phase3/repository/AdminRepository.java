package com.example.phase3.repository;

import com.example.phase3.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findAdminByEmailAndPassword(String email, String password);

    Admin getAdminByEmail(String email);
}
