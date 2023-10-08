package org.example.service.Impl;

import org.example.base.BaseRepository;
import org.example.entity.Specialist;
import org.example.repository.SpecialistRepository;
import org.example.service.SpecialistService;

import java.util.List;

public class SpecialistServiceImpl implements SpecialistService {

    private final SpecialistRepository specialistRepository;

    public SpecialistServiceImpl(SpecialistRepository specialistRepository) {
        this.specialistRepository = specialistRepository;
    }

    @Override
    public void saveSpecialist(Specialist specialist) {
        specialistRepository.saveSpecialist(specialist);
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
