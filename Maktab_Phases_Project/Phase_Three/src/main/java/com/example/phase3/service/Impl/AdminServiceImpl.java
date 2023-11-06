package com.example.phase3.service.Impl;

import com.example.phase3.entity.Admin;
import com.example.phase3.exception.AuthenticationException;
import com.example.phase3.repository.AdminRepository;
import com.example.phase3.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;


    @Override
    public Admin findAdminByEmailAndPassword(String email, String password) throws AuthenticationException {
        Admin admin =  adminRepository.findAdminByEmailAndPassword(email, password);
        if (admin == null) {
            throw new AuthenticationException("Could not find");
        }
        return admin;
    }

    @Override
    public List<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }

    @Override
    public void updateAdmin(String email, Admin admin) {
        Admin adminUpdate = adminRepository.getAdminByEmail(email);
        adminUpdate.setPassword(admin.getPassword());
        adminUpdate.setEmail(admin.getEmail());
        adminRepository.save(adminUpdate);
    }
}
