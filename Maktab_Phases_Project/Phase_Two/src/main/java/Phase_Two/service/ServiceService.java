package Phase_Two.service;

import Phase_Two.entity.Service;

import java.util.List;

public interface ServiceService {

    void saveService(Service service);

    Service getServiceById(Long id);

    Service getServiceByName(String name);

    List<Service> getAllSubServices();


    void updateService(Service service);

    void deleteService(Service service);
}
