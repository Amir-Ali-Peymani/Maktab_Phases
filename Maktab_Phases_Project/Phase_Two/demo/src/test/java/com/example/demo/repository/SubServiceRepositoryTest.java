package com.example.demo.repository;

import com.example.demo.entity.Service;
import com.example.demo.entity.SubService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SubServiceRepositoryTest {

    @Autowired
    private SubServiceRepository subServiceRepository;

    @Test
    public void testCreateSubService(){
        Service service = Service.builder()
                .name("test")
                .build();

        SubService subService = SubService.builder()
                .service(service)
                .name("testSubService")
                .basePrice(2234)
                .description("test description")
                .build();

        subServiceRepository.save(subService);
    }

    @Test
    public void testReadSubService(){
        SubService subService = subServiceRepository.findById(3L).orElse(null);
        assertNotNull(subService);
        System.out.println("SubService Name: " + subService.getName()
                +"SubService base_price: "+ subService.getBasePrice()
        + "SubService Description: "+ subService.getDescription());
    }

    @Test
    public void testUpdateSubService(){
        SubService subService = subServiceRepository.findById(3L).orElse(null);
        assertNotNull(subService);
        subService.setName("Test SubService Name");
        assertEquals("Test SubService Name", subService.getName());
        subServiceRepository.save(subService);
    }

    @Test
    public void testDeleteSubService(){
        SubService subService = subServiceRepository.findById(3L).orElse(null);
        assertNotNull(subService);
        subServiceRepository.delete(subService);
    }

}