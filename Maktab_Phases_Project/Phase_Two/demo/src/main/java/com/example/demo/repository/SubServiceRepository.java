package com.example.demo.repository;

import com.example.demo.entity.SubService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubServiceRepository extends JpaRepository<SubService, Long> {
}
