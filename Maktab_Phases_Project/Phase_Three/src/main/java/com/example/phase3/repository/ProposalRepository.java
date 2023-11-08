package com.example.phase3.repository;

import com.example.phase3.entity.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long> {
    Proposal getProposalById(Long id);
}
