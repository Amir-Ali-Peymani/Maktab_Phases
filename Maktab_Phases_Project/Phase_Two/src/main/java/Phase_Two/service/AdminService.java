package Phase_Two.service;

import Phase_Two.entity.Admin;

import java.util.List;

public interface AdminService {

    Admin getAdminById(Long id);

    Admin getAdminByEmailAndPassword(String email, String password);

    List<Admin> getAllAdmin();

    void updateAdmin(Admin admin);
}
