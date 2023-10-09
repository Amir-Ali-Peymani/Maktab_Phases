package org.example.service;

import org.example.entity.Admin;

import java.util.List;

public interface AdminService {

        Admin getAdminById(long id);

        List<Admin> getAllAdmin();

        void updateAdmin(Admin admin);
}
