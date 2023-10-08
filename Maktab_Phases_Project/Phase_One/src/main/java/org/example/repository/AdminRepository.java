package org.example.repository;

import org.example.entity.Admin;

public interface AdminRepository {

    Admin getAdminById(long id);

    void updateAdmin(Admin admin);

}
