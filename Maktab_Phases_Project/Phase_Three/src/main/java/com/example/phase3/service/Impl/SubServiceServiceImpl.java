package com.example.phase3.service.Impl;

import com.example.phase3.dto.SubServiceDTO;
import com.example.phase3.entity.SubService;
import com.example.phase3.exception.AuthenticationNotFoundException;
import com.example.phase3.exception.NullPointerException;
import com.example.phase3.repository.SubServiceRepository;
import com.example.phase3.service.SubServiceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubServiceServiceImpl implements SubServiceService {

    private final SubServiceRepository subServiceRepository;

    @Override
    public void saveSubService(SubService subService) throws NullPointerException {
        if (subService == null || subService.getService() == null) {
            throw new NullPointerException();
        }
        subServiceRepository.save(subService);
    }

    @Override
    public SubServiceDTO getSubServiceById(Long id) throws AuthenticationNotFoundException {
        SubService subService = subServiceRepository.getSubServiceById(id);
        if (subService == null){
            throw new AuthenticationNotFoundException();
        }
        return SubServiceDTO.fromSubService(subService);
    }

    @Override
    public SubServiceDTO getSubServiceByName(String name) throws AuthenticationNotFoundException {
        SubService subService = subServiceRepository.getSubServiceByName(name);
        if (subService == null){
            throw new AuthenticationNotFoundException();
        }
        return SubServiceDTO.fromSubService(subService);
    }

    @Override
    public List<SubServiceDTO> getAllSubServices() {
        List<SubService> subServices = subServiceRepository.findAll();
        return subServices.stream()
                .map(SubServiceDTO::fromSubService)
                .toList();
    }

    @Override
    public void updateSubService(long id, SubService subService) throws NullPointerException {
        SubService subServiceUpdate = subServiceRepository.getSubServiceById(id);
        if (subServiceUpdate == null){
            throw new NullPointerException();
        }
        subServiceUpdate.setName(subService.getName());
        subServiceRepository.save(subServiceUpdate);
    }

    @Override
    public void deleteSubService(long id) throws AuthenticationNotFoundException {
        SubService subService = subServiceRepository.getSubServiceById(id);
        if (subService == null){
            throw new AuthenticationNotFoundException();
        }
        subServiceRepository.delete(subService);
    }
}
