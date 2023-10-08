package org.example.repository;

import org.example.entity.Specialist;

import java.util.List;

public interface SpecialistRepository {

    void saveSpecialist(Specialist specialist);

    Specialist getSpecialistById(Long id);

    List<Specialist> getAllSpecialists();

    void updateSpecialist(Specialist specialist);

    void deleteSpecialist(Specialist specialist);
}
