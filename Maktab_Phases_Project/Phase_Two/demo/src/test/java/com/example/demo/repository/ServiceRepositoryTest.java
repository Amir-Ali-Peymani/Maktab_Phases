package com.example.demo.repository;

import com.example.demo.entity.Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ServiceRepositoryTest {

    @Autowired
    private ServiceRepository serviceRepository;

    @Test
    public void testCreateSubService(){
        Service service = Service.builder()
                .name("TestService")
                .build();
        serviceRepository.save(service);
    }

    @Test
    public void testReadService(){
        Service service = serviceRepository.findById(1L).orElse(null);
        assertNotNull(service);
        System.out.println("Service Name: " + service.getName());
    }

    @Test
    public void testUpdateService(){
        Service service = serviceRepository.findById(1L).orElse(null);
        assertNotNull(service);
        service.setName("test");
        assertEquals("test", service.getName());
        serviceRepository.save(service);
    }


    @Test public void deleteService(){
        Service service = serviceRepository.findById(3L).orElse(null);
        assertNotNull(service);
        serviceRepository.delete(service);
    }

}