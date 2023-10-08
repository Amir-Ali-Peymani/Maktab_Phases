package org.example.service;

import org.example.entity.Admin;

public interface AdminService {

        Admin getAdminById(long id);

        void updateAdmin(Admin admin);
}
