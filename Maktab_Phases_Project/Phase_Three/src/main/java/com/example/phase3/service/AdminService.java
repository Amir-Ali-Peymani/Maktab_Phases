package com.example.phase3.service;

import com.example.phase3.entity.Admin;
import com.example.phase3.exception.AuthenticationException;

import java.util.List;

public interface AdminService {

    Admin findAdminByEmailAndPassword(String email, String password) throws AuthenticationException;

    List<Admin> getAllAdmin();

    void updateAdmin(String email, Admin admin);
}
