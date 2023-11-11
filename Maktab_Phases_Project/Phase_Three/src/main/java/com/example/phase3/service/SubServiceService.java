package com.example.phase3.service;

import com.example.phase3.dto.SubServiceDTO;
import com.example.phase3.exception.AuthenticationNotFoundException;
import com.example.phase3.exception.NullPointerException;
import com.example.phase3.entity.SubService;

import java.util.List;


public interface SubServiceService {

    void saveSubService(SubService subService) throws NullPointerException;

    SubServiceDTO getSubServiceById(Long id) throws AuthenticationNotFoundException;

    SubServiceDTO getSubServiceByName(String name) throws AuthenticationNotFoundException;

    List<SubServiceDTO> getAllSubServices();

    void updateSubService(long id, SubService subService) throws NullPointerException;

    void deleteSubService(long id) throws AuthenticationNotFoundException;
}
