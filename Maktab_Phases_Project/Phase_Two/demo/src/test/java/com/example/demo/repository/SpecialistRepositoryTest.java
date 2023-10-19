package com.example.demo.repository;

import com.example.demo.entity.Specialist;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpecialistRepositoryTest {

    @Autowired
    private SpecialistRepository specialistRepository;

    @Test
    public void testCreateSpecialist(){
        Specialist specialist = Specialist.builder()
                .firstName("Naser")
                .lastName("nasery")
                .email("naser@gmail.com")
                .password("password")
                .build();
        specialistRepository.save(specialist);
    }


    @Test
    public void testReadSpecialist(){
        Specialist specialist = specialistRepository.findById(1L).orElse(null);
        assertNotNull(specialist);
        System.out.println("Specialist name: "+ specialist.getFirstName());
    }

    @Test
    public void testUpdateSpecialist(){
        Specialist specialist = specialistRepository.findById(1L).orElse(null);
        assertNotNull(specialist);
        specialist.setLastName("peymani");
        assertEquals("peymani", specialist.getLastName());
        specialistRepository.save(specialist);
    }

    @Test
    public void testDelete(){
        Specialist specialist = specialistRepository.findById(1L).orElse(null);
        assertNotNull(specialist);
        specialistRepository.delete(specialist);
    }

}