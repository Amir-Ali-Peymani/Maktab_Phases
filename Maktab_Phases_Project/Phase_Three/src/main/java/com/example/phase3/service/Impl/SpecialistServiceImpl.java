package com.example.phase3.service.Impl;

import com.example.phase3.entity.Specialist;
import com.example.phase3.enumeration.SpecialistStatus;
import com.example.phase3.exception.*;
import com.example.phase3.exception.NullPointerException;
import com.example.phase3.repository.SpecialistRepository;
import com.example.phase3.service.SpecialistService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SpecialistServiceImpl implements SpecialistService {

    private final SpecialistRepository specialistRepository;

    @Override
    public void saveSpecialist(Specialist specialist) throws NullPointerException {
        if (specialist == null) {
            throw new NullPointerException();
        }
        specialist.setSpecialistStatus(SpecialistStatus.NEW);
        specialistRepository.save(specialist);
    }

    @Override
    public Specialist getCustomerByEmailAndPassword(String email, String password) throws InvalidUserNameAndPasswordException, AuthenticationNotFoundException {
        if (email == null || email.equals("") || password == null || password.equals("")){
            throw new InvalidUserNameAndPasswordException();
        }
        Specialist specialist = specialistRepository.getSpecialistByEmailAndPassword(email, password);
        if (specialist == null){
            throw new AuthenticationNotFoundException();
        }
        return specialist;
    }


    @Override
    public List<Specialist> getAllSpecialists() {
        return specialistRepository.findAll();
    }

    @Override
    public void updateSpecialist(String email, Specialist specialist) throws InvalidEmailException, NullPointerException {
        if (email == null || email.equals("")) {
            throw new InvalidEmailException();
        }
        Specialist specialistUpdate = specialistRepository.findByEmail(email);
        if (specialist == null) {
            throw new NullPointerException();
        }
        specialistUpdate.setEmail(specialist.getEmail());
        specialistUpdate.setPassword(specialist.getPassword());
        specialistRepository.save(specialist);
    }

    @Override
    public void deleteSpecialist(long id) throws AuthenticationNotFoundException {
        Specialist specialist = specialistRepository.getSpecialistById(id);
        if (specialist == null) {
            throw new AuthenticationNotFoundException();
        }
        specialistRepository.delete(specialist);
    }
}
