package org.example.service.Impl;

import org.example.base.BaseRepository;
import org.example.entity.SubService;
import org.example.repository.SubServiceRepository;
import org.example.service.SubServiceService;

import java.util.List;

public class SubServiceServiceImpl implements SubServiceService {

    private final SubServiceRepository subServiceRepository;

    public SubServiceServiceImpl(SubServiceRepository subServiceRepository) {
        this.subServiceRepository = subServiceRepository;
    }


    @Override
    public void saveSubService(SubService subService) {
        subServiceRepository.saveSubService(subService);
    }

    @Override
    public SubService getSubServiceById(Long id) {
        return subServiceRepository.getSubServiceById(id);
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
