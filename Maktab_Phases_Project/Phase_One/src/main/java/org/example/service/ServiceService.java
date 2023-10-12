package org.example.service;

import org.example.entity.Service;

import java.util.List;

public interface ServiceService {

    void saveService(Service service);

    Service getServiceById(long id);

    Service getServiceByName(String name);

    List<Service> getAllServices();

    void updateService(Service service);

    void deleteService(Service service);
}
