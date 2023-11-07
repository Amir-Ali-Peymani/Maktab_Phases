package com.example.phase3.service;

import com.example.phase3.entity.Admin;
import com.example.phase3.exception.AuthenticationException;
import com.example.phase3.exception.AuthenticationNotFoundException;
import com.example.phase3.exception.InvalidEmailException;
import com.example.phase3.exception.InvalidUserNameAndPasswordException;
import com.example.phase3.exception.NullPointerException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    Admin findAdminByEmailAndPassword(String email, String password) throws AuthenticationNotFoundException,
            InvalidUserNameAndPasswordException;

    List<Admin> getAllAdmin();

    void updateAdmin(String email, Admin admin) throws InvalidEmailException, NullPointerException;
}
