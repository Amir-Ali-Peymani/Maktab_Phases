package org.example.service.Impl;

import org.example.entity.SubService;
import org.example.repository.SubServiceRepository;
import org.example.service.SubServiceService;
import org.example.util.ServiceLocator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubServiceServiceImpl implements SubServiceService {

    private final SubServiceRepository subServiceRepository;

    public SubServiceServiceImpl(SubServiceRepository subServiceRepository) {
        this.subServiceRepository = subServiceRepository;
    }


    @Override
    public void saveSubService(SubService subService) {
        Set<String> addedSubServices = new HashSet<>();
        List<SubService> subServiceList = ServiceLocator.getSubServiceService().getAllSubServices();

        for (SubService subServiceLoop : subServiceList) {
            addedSubServices.add(subServiceLoop.getName());
        }
        if (addedSubServices.contains(subService.getName())) {
            System.out.println("This Sub-Service already exists in the database.");
        } else if (subService.getService() != null){
            subServiceRepository.saveSubService(subService);
            System.out.println("Sub-Service added to the database.");
        }
    }

    @Override
    public SubService getSubServiceById(Long id) {
        return subServiceRepository.getSubServiceById(id);
    }

    @Override
    public SubService getSubServiceByName(String name) {
        return subServiceRepository.getSubServiceByName(name);
    }

    @Override
    public List<SubService> getAllSubServices() {
        return subServiceRepository.getAllSubServices();
    }

    @Override
    public void updateSubService(SubService subService) {
        subServiceRepository.updateSubService(subService);
    }

    @Override
    public void deleteSubService(SubService subService) {
        subServiceRepository.deleteSubService(subService);
    }
}
