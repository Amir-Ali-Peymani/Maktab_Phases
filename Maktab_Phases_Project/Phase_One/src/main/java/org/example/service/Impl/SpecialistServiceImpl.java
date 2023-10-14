package org.example.service.Impl;

import org.example.base.BaseRepository;
import org.example.entity.Specialist;
import org.example.repository.SpecialistRepository;
import org.example.service.SpecialistService;
import org.example.util.ServiceLocator;
import org.example.util.Validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpecialistServiceImpl implements SpecialistService {

    private final SpecialistRepository specialistRepository;

    public SpecialistServiceImpl(SpecialistRepository specialistRepository) {
        this.specialistRepository = specialistRepository;
    }

    @Override
    public void saveSpecialist(Specialist specialist) {
        boolean isEmailValid = Validation.isValidEmail(specialist.getEmail());
        boolean isPasswordValid = Validation.isValidPassword(specialist.getPassword());

        if (!isEmailValid && !isPasswordValid) {
            System.out.println("Email and password are not valid. Information not saved.");
        } else if (!isEmailValid) {
            System.out.println("Email is not valid. Information not saved.");
        } else if (!isPasswordValid) {
            System.out.println("Password is not valid. Information not saved.");
        } else {
            Set<String> addedSpecialist = new HashSet<>();
            List<Specialist> specialistsList = ServiceLocator.getSpecialtyService().getAllSpecialists();

            for (Specialist specialistLoop : specialistsList) {
                addedSpecialist.add(specialistLoop.getEmail());
            }

            if (addedSpecialist.contains(specialist.getEmail())) {
                System.out.println("This specialist already exists. Information not saved.");
            } else {
                specialistRepository.saveSpecialist(specialist);
                System.out.println("Specialist added to the database.");
            }
        }
    }


    @Override
    public Specialist getSpecialistById(Long id) {
        return specialistRepository.getSpecialistById(id);
    }

    @Override
    public List<Specialist> getAllSpecialists() {
        return specialistRepository.getAllSpecialists();
    }

    @Override
    public void updateSpecialist(Specialist specialist) {
        specialistRepository.updateSpecialist(specialist);
    }

    @Override
    public void deleteSpecialist(Specialist specialist) {
        specialistRepository.deleteSpecialist(specialist);
    }
}
