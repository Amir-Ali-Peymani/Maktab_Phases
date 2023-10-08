package org.example.repository;

import org.example.entity.Service;

import java.util.List;

public interface ServiceRepository {

    void saveService(Service service);

    Service getServiceById(Long id);

    List<Service> getAllServices();

    void updateService(Service service);

    void deleteService(Service service);
}
