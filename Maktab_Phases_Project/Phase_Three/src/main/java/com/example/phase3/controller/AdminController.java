package com.example.phase3.controller;


import com.example.phase3.entity.Admin;
import com.example.phase3.exception.AuthenticationException;
import com.example.phase3.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/getAllAdmin")
    public ResponseEntity<?> getAllAdmin(){
        try {
            List<Admin> adminList = adminService.getAllAdmin();
            return ResponseEntity.ok(adminList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
        }
    }

    @PutMapping("/updateAdmin/{email}")
    public void updateAdmin(@PathVariable("email") String email,
                            @RequestBody Admin admin){
        adminService.updateAdmin(email, admin);
    }
}
