package com.example.phase3.repository;

import com.example.phase3.entity.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {

    Credit getCreditById(Long id);
}
