package Phase_Two.repository;

import Phase_Two.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerByEmailAndPassword(String email, String password);

    Customer findCustomerByEmail(String email);
}
