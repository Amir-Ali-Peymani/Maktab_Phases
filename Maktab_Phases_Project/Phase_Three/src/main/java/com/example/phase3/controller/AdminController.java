package com.example.phase3.controller;


import com.example.phase3.entity.Admin;
import com.example.phase3.exception.AuthenticationException;
import com.example.phase3.service.AdminService;
import com.example.phase3.service.Impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/login/{email}/{password}")
    public Admin getAdmin(@PathVariable("email") String email,
                          @PathVariable("password") String password
    ) throws AuthenticationException {
        return adminService.findAdminByEmailAndPassword(email, password);
    }

    @GetMapping("/getAllAdmin")
    public List<Admin> getAllAdmin(){
        return adminService.getAllAdmin();
    }

    @PutMapping("/updateAdmin/{email}")
    public void updateAdmin(@PathVariable("email") String email,
                            @RequestBody Admin admin){
        adminService.updateAdmin(email, admin);
    }
}
