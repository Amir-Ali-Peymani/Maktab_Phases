package Phase_Two.service.Impl;

import Phase_Two.entity.Admin;
import Phase_Two.repository.AdminRepository;
import Phase_Two.service.AdminService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Override
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    @Override
    public Admin getAdminByEmailAndPassword(String email, String password) {
        return adminRepository.getAdminByEmailAndPassword(email, password);
    }



    @Override
    public List<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminRepository.save(admin);
    }
}
