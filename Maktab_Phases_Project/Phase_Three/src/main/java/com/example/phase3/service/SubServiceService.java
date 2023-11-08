package com.example.phase3.service;

import com.example.phase3.exception.AuthenticationNotFoundException;
import com.example.phase3.exception.NullPointerException;
import com.example.phase3.entity.SubService;

import java.util.List;


public interface SubServiceService {

    void saveSubService(SubService subService) throws NullPointerException;

    SubService getSubServiceById(Long id) throws AuthenticationNotFoundException;

    SubService getSubServiceByName(String name) throws AuthenticationNotFoundException;

    List<SubService> getAllSubServices();

    void updateSubService(long id, SubService subService) throws NullPointerException;

    void deleteSubService(long id) throws AuthenticationNotFoundException;
}
