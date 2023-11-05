package Phase_Two.service;

import Phase_Two.entity.Customer;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface CustomerService {

    void saveCustomer(Customer customer);

    Customer getCustomerById(Long id);

    List<Customer> getAllCustomer();

    void updateCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}
