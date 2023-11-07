package com.example.phase3.service;

import com.example.phase3.entity.Admin;
import com.example.phase3.exception.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    Admin findAdminByEmailAndPassword(String email, String password) throws AuthenticationException;

    List<Admin> getAllAdmin();

    void updateAdmin(String email, Admin admin);
}
