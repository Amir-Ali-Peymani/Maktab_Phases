package org.example.service.Impl;

import org.example.base.BaseRepository;
import org.example.entity.Service;
import org.example.repository.ServiceRepository;
import org.example.service.ServiceService;
import org.example.util.ServiceLocator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    public ServiceServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }


    @Override
    public void saveService(Service service) {
        Set<String> addedServices = new HashSet<>();
        List<Service> services = ServiceLocator.getServiceService().getAllServices();

        for (Service loopService : services) {
            addedServices.add(loopService.getName());
        }

        if (addedServices.contains(service.getName())) {
            System.out.println("This service already exists in the database.");
        } else {
            serviceRepository.saveService(service);
            System.out.println("Service added to the database.");
        }
    }

    @Override
    public Service getServiceById(long id) {
        Service service = serviceRepository.getServiceById(id);
        if (service == null) {
            System.out.println("Service not found");
            return null;
        } else {
            return service;
        }
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
        for (Service serviceLoop : getAllServices()) {
            if (serviceLoop.equals(service)) {
                serviceRepository.updateService(service);
            } else {
                System.out.println("this service doesn't exist");
            }
        }
    }

    @Override
    public void deleteService(Service service) {
        for (Service serviceLoop : getAllServices()){
            if (serviceLoop.equals(service)){
                serviceRepository.deleteService(service);
            } else {
                System.out.println("this service doesn't exist");
            }
        }
    }
}
