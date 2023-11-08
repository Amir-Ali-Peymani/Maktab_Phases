package com.example.phase3.service;

import com.example.phase3.entity.Service;
import com.example.phase3.exception.AuthenticationNotFoundException;
import com.example.phase3.exception.NullPointerException;

import java.util.List;

public interface ServiceService {

    void saveService(Service service) throws NullPointerException;

    Service getServiceById(Long id) throws AuthenticationNotFoundException;

    Service getServiceByName(String name) throws AuthenticationNotFoundException;

    List<Service> getAllServices();

    void updateService(long id, Service service) throws NullPointerException;

    void deleteService(Long id) throws AuthenticationNotFoundException;
}
