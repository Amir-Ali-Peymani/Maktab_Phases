package org.example.repository;

import org.example.entity.Admin;

import java.util.List;

public interface AdminRepository {

    Admin getAdminById(long id);

    List<Admin> getAllAdmin();

    void updateAdmin(Admin admin);

}
