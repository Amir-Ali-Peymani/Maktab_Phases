package Phase_Two.repository;

import Phase_Two.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin getAdminByEmailAndPassword(String firstName, String password);

    Admin getAdminByEmail(String email);

}
