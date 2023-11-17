package com.example.phase3.service;


import com.example.phase3.dto.SpecialistDTO;
import com.example.phase3.entity.Proposal;
import com.example.phase3.entity.Specialist;
import com.example.phase3.exception.*;
import com.example.phase3.exception.NullPointerException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface SpecialistService {

    void saveSpecialist(Specialist specialist) throws NullPointerException;

    SpecialistDTO getCustomerByEmailAndPassword(String email, String password) throws AuthenticationException, InvalidUserNameAndPasswordException;

    List<SpecialistDTO> getAllSpecialists();

    void updateSpecialist(String email, Specialist specialist) throws InvalidEmailException, NullPointerException;

    void deleteSpecialist(long id) throws AuthenticationNotFoundException;

    void specialistsGiveProposal(long id, long orderId, Proposal proposal) throws UnAuthorizedSpecialistException;
    
    String uploadImage(long id, MultipartFile file) throws IOException;

    byte[] downloadImage(long id);
}
