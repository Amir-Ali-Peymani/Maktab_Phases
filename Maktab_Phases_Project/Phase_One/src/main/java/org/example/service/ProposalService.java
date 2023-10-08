package org.example.service;

import org.example.entity.Proposal;

import java.util.List;

public interface ProposalService {

    void saveProposal(Proposal proposal);

    Proposal getProposalById(Long id);

    List<Proposal> getAllProposals();

    void updateProposal(Proposal proposal);

    void deleteProposal(Proposal proposal);

}
