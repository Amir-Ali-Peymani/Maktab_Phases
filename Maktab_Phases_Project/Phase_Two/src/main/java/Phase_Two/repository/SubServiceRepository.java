package Phase_Two.repository;

import Phase_Two.entity.SubService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubServiceRepository extends JpaRepository<SubService, Long> {

    SubService getSubServiceByName(String name);
}
