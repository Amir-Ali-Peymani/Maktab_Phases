package Phase_Two.repository;

import Phase_Two.entity.Service;
import Phase_Two.entity.SubService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SubServiceRepositoryTest {

    @Autowired
    private SubServiceRepository subServiceRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Test
    public void testCreateSubService(){
        Service service = Service.builder()
                .name("test")
                .build();
        serviceRepository.save(service);
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
        SubService subService = subServiceRepository.getSubServiceByName("testSubService");
        assertNotNull(subService);
        System.out.println("SubService Name: " + subService.getName()
                +"SubService base_price: "+ subService.getBasePrice()
                + "SubService Description: "+ subService.getDescription());
    }

    @Test
    public void testUpdateSubService(){
        SubService subService = subServiceRepository.getSubServiceByName("testSubService");
        assertNotNull(subService);
        subService.setBasePrice(5000);
        subService.setDescription("description changed");
        assertEquals(5000, subService.getBasePrice());
        assertEquals("description changed", subService.getDescription());
        subServiceRepository.save(subService);
    }

    @Test
    public void testDeleteSubService(){
        SubService subService = subServiceRepository.getSubServiceByName("Test SubService Name");
        assertNotNull(subService);
        subServiceRepository.delete(subService);
    }

}