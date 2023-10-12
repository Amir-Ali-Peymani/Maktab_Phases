package org.example.service.Impl;

import org.example.base.BaseRepository;
import org.example.entity.Service;
import org.example.repository.ServiceRepository;
import org.example.service.ServiceService;

import java.util.List;

public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    public ServiceServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }


    @Override
    public void saveService(Service service) {
        serviceRepository.saveService(service);
    }

    @Override
    public Service getServiceById(long id) {
        return serviceRepository.getServiceById(id);
    }

    @Override
    public Service getServiceByName(String name) {
        return serviceRepository.getServiceByName(name);
    }

    @Override
    public List<Service> getAllServices() {
        return serviceRepository.getAllServices();
    }

    @Override
    public void updateService(Service service) {
        serviceRepository.updateService(service);
    }

    @Override
    public void deleteService(Service service) {
        serviceRepository.deleteService(service);
    }
}
