package org.example.repository;

import org.example.entity.Service;

import java.util.List;

public interface ServiceRepository {

    void saveService(Service service);

    Service getServiceById(Long id);

    Service getServiceByName(String name);

    List<Service> getAllServices();

    void updateService(Service service);

    void deleteService(Service service);
}
