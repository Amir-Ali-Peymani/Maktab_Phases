package com.example.phase3.repository;


import com.example.phase3.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
    Service getServicesByName(String name);

    Service getServicesById(Long id);
}
