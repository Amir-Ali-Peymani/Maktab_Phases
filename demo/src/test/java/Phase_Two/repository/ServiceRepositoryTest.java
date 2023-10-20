package Phase_Two.repository;

import Phase_Two.entity.Service;
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
        Service service = serviceRepository.getServiceByName("TestService");
        assertNotNull(service);
        System.out.println("Service Name: " + service.getName());
    }

    @Test
    public void testUpdateService(){
        Service service = serviceRepository.getServiceByName("TestService");
        assertNotNull(service);
        service.setName("test");
        assertEquals("test", service.getName());
        serviceRepository.save(service);
    }


    @Test public void deleteService(){
        Service service = serviceRepository.getServiceByName("test");
        assertNotNull(service);
        serviceRepository.delete(service);
    }

}