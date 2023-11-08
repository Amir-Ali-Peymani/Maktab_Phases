package com.example.phase3.service;

import com.example.phase3.entity.Proposal;

import java.util.List;

public interface ProposalService {

    void saveProposal(Proposal proposal);

    Proposal getProposalById(Long id);

    List<Proposal> getAllProposals();

    void updateProposal(long id, Proposal proposal);

    void deleteProposal(long id);
}
