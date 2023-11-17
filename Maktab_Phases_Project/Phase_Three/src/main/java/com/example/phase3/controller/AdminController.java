package com.example.phase3.controller;


import com.example.phase3.entity.Admin;
import com.example.phase3.exception.*;
import com.example.phase3.exception.NullPointerException;
import com.example.phase3.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

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

    @PostMapping("/confirmSpecialist/{id}")
    public void confirmSpecialist(@PathVariable("id")long id){
        adminService.confirmingSpecialist(id);
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
