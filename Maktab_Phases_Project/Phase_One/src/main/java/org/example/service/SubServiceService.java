package org.example.service;

import org.example.entity.SubService;

import java.util.List;

public interface SubServiceService {

    void saveSubService(SubService subService);

    SubService getSubServiceById(Long id);

    SubService getSubServiceByName(String name);

    List<SubService> getAllSubServices();

    void updateSubService(SubService subService);

    void deleteSubService(SubService subService);
}
