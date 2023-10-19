package com.example.demo.repository;

import com.example.demo.entity.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminRepositoryTest {

    @Autowired
    private AdminRepository adminRepository;

    @Test
    public void testCreateAdmin(){
        Admin admin = Admin.builder()
                .firstName("Naer")
                .lastName("akbari")
                .email("akbari.doe@example.com")
                .password("1234")
                .build();
        adminRepository.save(admin);
    }

    @Test
    public void testReadAdmin(){
        Admin admin = adminRepository.findById(1L).orElse(null);
        assertNotNull(admin);
        System.out.println("admin name: "+ admin.getFirstName() +
                "admin lastName: "+ admin.getLastName() + "admin email" +
                admin.getEmail());
    }

    @Test
    public void testUpdateAdmin(){
        Admin admin = adminRepository.findById(4L).orElse(null);
        assertNotNull(admin);
        admin.setFirstName("hossein");
        assertEquals("hossein", admin.getFirstName());
        adminRepository.save(admin);
    }


    @Test
    public void testDeleteAdmin(){
        Admin admin = adminRepository.findById(5L).orElse(null);
        assertNotNull(admin);
        adminRepository.delete(admin);

    }


}