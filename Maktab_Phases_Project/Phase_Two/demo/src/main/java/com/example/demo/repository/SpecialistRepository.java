package com.example.demo.repository;

import com.example.demo.entity.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialistRepository extends JpaRepository<Specialist, Long> {
}
