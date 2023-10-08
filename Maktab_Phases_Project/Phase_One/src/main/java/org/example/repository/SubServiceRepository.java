package org.example.repository;

import org.example.entity.SubService;

import java.util.List;

public interface SubServiceRepository {

    void saveSubService(SubService subService);

    SubService getSubServiceById(Long id);

    List<SubService> getAllSubServices();

    void updateSubService(SubService subService);

    void deleteSubService(SubService subService);
}
