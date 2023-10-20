package Phase_Two.repository;

import Phase_Two.entity.Admin;
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
                .email("hosseiny.doe@example.com")
                .password("1234")
                .build();
        adminRepository.save(admin);
    }

    @Test
    public void testReadAdmin(){
        Admin admin = adminRepository.getAdminByEmailAndPassword("hosseiny.doe@example.com", "1234");
        assertNotNull(admin);
        System.out.println("admin name: "+ admin.getFirstName() +
                "admin lastName: "+ admin.getLastName() + "admin email" +
                admin.getEmail());
    }

    @Test
    public void testUpdateAdmin(){
        Admin admin = adminRepository.getAdminByEmail("hosseiny.doe@example.com");
        assertNotNull(admin);
        admin.setPassword("hossein");
        assertEquals("hossein", admin.getPassword());
        adminRepository.save(admin);
    }


    @Test
    public void testDeleteAdmin(){
        Admin admin = adminRepository.getAdminByEmail("hosseiny.doe@example.com");
        assertNotNull(admin);
        adminRepository.delete(admin);

    }

}