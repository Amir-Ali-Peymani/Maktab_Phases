package com.example.phase3.repository;

import com.example.phase3.entity.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialistRepository extends JpaRepository<Specialist, Long> {

    Specialist getSpecialistByEmailAndPassword(String email, String password);

    Specialist findByEmail(String email);

    Specialist getSpecialistById(Long id);

}
