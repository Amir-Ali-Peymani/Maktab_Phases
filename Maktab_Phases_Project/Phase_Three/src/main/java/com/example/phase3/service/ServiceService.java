package com.example.phase3.service;

import com.example.phase3.dto.ServiceDTO;
import com.example.phase3.entity.Service;
import com.example.phase3.exception.AuthenticationNotFoundException;
import com.example.phase3.exception.NullPointerException;

import java.util.List;

@org.springframework.stereotype.Service
public interface ServiceService {

    void saveService(Service service) throws NullPointerException;

    ServiceDTO getServiceById(Long id) throws AuthenticationNotFoundException;

    ServiceDTO getServiceByName(String name) throws AuthenticationNotFoundException;

    List<ServiceDTO> getAllServices();

    void updateService(long id, Service service) throws NullPointerException;

    void deleteService(Long id) throws AuthenticationNotFoundException;
}
