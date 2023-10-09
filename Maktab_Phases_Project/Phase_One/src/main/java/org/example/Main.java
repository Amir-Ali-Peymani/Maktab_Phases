package org.example;

import org.example.entity.Admin;
import org.example.repository.AdminRepository;
import org.example.repository.Impl.AdminRepositoryImpl;
import org.example.service.AdminService;
import org.example.service.Impl.AdminServiceImpl;
import org.example.util.ServiceLocator;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        signInAdmin("john.doe@example.com", "password123");
    }


    private static void signInAdmin(String userName, String password){
        List<Admin> admins = ServiceLocator.getAdminService().getAllAdmin();
        for (Admin admin : admins){
            if (admin.getEmail().equals(userName) && admin.getPassword().equals(password)){
                System.out.println("you have log in successfully");
            } else {
                System.out.println(" you have failed to signIn");
            }
        }
    }
}
