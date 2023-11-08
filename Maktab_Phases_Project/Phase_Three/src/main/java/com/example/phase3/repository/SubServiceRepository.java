package com.example.phase3.repository;

import com.example.phase3.entity.SubService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubServiceRepository extends JpaRepository<SubService, Long> {
    SubService getSubServiceById(long id);

    SubService getSubServiceByName(String name);
}
