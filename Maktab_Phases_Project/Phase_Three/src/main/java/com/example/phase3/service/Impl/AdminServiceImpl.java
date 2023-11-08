package com.example.phase3.service.Impl;

import com.example.phase3.entity.Admin;
import com.example.phase3.exception.AuthenticationNotFoundException;
import com.example.phase3.exception.InvalidEmailException;
import com.example.phase3.exception.InvalidUserNameAndPasswordException;
import com.example.phase3.exception.NullPointerException;
import com.example.phase3.repository.AdminRepository;
import com.example.phase3.service.AdminService;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;


    @Override
    public Admin findAdminByEmailAndPassword(@Email String email, String password) throws AuthenticationNotFoundException,
            InvalidUserNameAndPasswordException {
        if (email == null || email.equals("") ||  password == null || password.equals("")) {
            throw new InvalidUserNameAndPasswordException();
        }
        Admin admin =  adminRepository.findAdminByEmailAndPassword(email, password);
        if (admin == null) {
            throw new AuthenticationNotFoundException();
        }
        return admin;
    }

    @Override
    public List<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }

    @Override
    public void updateAdmin(String email, Admin admin) throws InvalidEmailException, NullPointerException {
        if (email == null || email.equals("")) {
            throw new InvalidEmailException();
        }
        Admin adminUpdate = adminRepository.getAdminByEmail(email);
        if (admin == null) {
            throw new NullPointerException();
        }
        adminUpdate.setPassword(admin.getPassword());
        adminUpdate.setEmail(admin.getEmail());
        adminRepository.save(adminUpdate);
    }
}
