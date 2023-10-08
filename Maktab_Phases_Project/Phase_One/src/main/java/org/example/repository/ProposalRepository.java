package org.example.repository;

import org.example.entity.Proposal;

import java.util.List;

public interface ProposalRepository {

    void saveProposal(Proposal proposal);

    Proposal getProposalById(Long id);

    List<Proposal> getAllProposals();

    void updateProposal(Proposal proposal);

    void deleteProposal(Proposal proposal);

}
