package org.example.service.Impl;

import org.example.base.BaseRepository;
import org.example.entity.Admin;
import org.example.repository.AdminRepository;
import org.example.repository.Impl.AdminRepositoryImpl;
import org.example.service.AdminService;

public class AdminServiceImpl  implements AdminService {

    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }
    @Override
    public Admin getAdminById(long id) {
        return adminRepository.getAdminById(id);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminRepository.updateAdmin(admin);
    }
}
