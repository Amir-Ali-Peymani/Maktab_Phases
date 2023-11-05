package Phase_Two.repository;

import Phase_Two.entity.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialistRepository extends JpaRepository<Specialist, Long> {

    Specialist getSpecialistByEmailAndPassword(String email, String password);

    Specialist findByEmail(String email);

}
