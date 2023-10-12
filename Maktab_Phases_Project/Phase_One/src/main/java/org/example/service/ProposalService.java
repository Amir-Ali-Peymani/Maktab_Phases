package org.example.service;

import org.example.entity.Order;
import org.example.entity.Proposal;
import org.example.entity.Specialist;

import java.util.List;

public interface ProposalService {

    void saveProposal(Proposal proposal);

    Proposal getProposalById(Long id);

    Proposal getProposalByOrderAndSpecialist(Order order, Specialist specialist);

    List<Proposal> getAllProposals();

    void updateProposal(Proposal proposal);

    void deleteProposal(Proposal proposal);

}
