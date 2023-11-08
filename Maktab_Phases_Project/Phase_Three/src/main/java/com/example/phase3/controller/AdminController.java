package com.example.phase3.controller;


import com.example.phase3.entity.Admin;
import com.example.phase3.exception.*;
import com.example.phase3.exception.NullPointerException;
import com.example.phase3.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/login/{email}/{password}")
    public ResponseEntity<?> getAdmin(@PathVariable("email") String email,
                                   @PathVariable("password") String password
    ){
        try {
            Admin admin = adminService.findAdminByEmailAndPassword(email, password);
            return ResponseEntity.ok(admin);
        } catch (BaseHttpException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

    @GetMapping("/getAllAdmin")
    public List<Admin> getAllAdmin(){
        return adminService.getAllAdmin();
    }

    @PutMapping("/updateAdmin/{email}")
    public void updateAdmin(@PathVariable("email") String email,
                            @RequestBody Admin admin) throws NullPointerException, InvalidEmailException {
        adminService.updateAdmin(email, admin);
    }
}
