package com.example.phase3.service.Impl;

import com.example.phase3.entity.Service;
import com.example.phase3.exception.AuthenticationNotFoundException;
import com.example.phase3.exception.NullPointerException;
import com.example.phase3.repository.ServiceRepository;
import com.example.phase3.service.ServiceService;
import lombok.AllArgsConstructor;

import java.util.List;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    @Override
    public void saveService(Service service) throws NullPointerException {
        if (service == null) {
            throw new NullPointerException();
        }
        serviceRepository.save(service);
    }

    @Override
    public Service getServiceById(Long id) throws AuthenticationNotFoundException {
        Service service = serviceRepository.getServicesById(id);
        if (service == null) {
            throw new AuthenticationNotFoundException();
        }
        return service;
    }

    @Override
    public Service getServiceByName(String name) throws AuthenticationNotFoundException {
        Service service = serviceRepository.getServicesByName(name);
        if (service == null) {
            throw new AuthenticationNotFoundException();
        }
        return service;
    }

    @Override
    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    @Override
    public void updateService(long id, Service service) throws NullPointerException {
        Service serviceUpdate = serviceRepository.getServicesById(id);
        if (service == null) {
            throw new NullPointerException();
        }
        serviceUpdate.setName(service.getName());
        serviceRepository.save(serviceUpdate);
    }

    @Override
    public void deleteService(Long id) throws AuthenticationNotFoundException {
        Service service = serviceRepository.getServicesById(id);
        if (service == null) {
            throw new AuthenticationNotFoundException();
        }
        serviceRepository.delete(service);
    }
}
