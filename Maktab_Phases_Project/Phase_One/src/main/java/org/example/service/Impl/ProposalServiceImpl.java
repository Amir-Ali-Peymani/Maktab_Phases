package org.example.service.Impl;

import org.example.entity.Proposal;
import org.example.repository.ProposalRepository;
import org.example.service.ProposalService;

import java.util.List;

public class ProposalServiceImpl implements ProposalService {

    private final ProposalRepository proposalRepository;

    public ProposalServiceImpl(ProposalRepository proposalRepository) {
        this.proposalRepository = proposalRepository;
    }

    @Override
    public void saveProposal(Proposal proposal) {
        proposalRepository.saveProposal(proposal);
    }

    @Override
    public Proposal getProposalById(Long id) {
        return proposalRepository.getProposalById(id);
    }

    @Override
    public List<Proposal> getAllProposals() {
        return proposalRepository.getAllProposals();
    }

    @Override
    public void updateProposal(Proposal proposal) {
        proposalRepository.updateProposal(proposal);
    }

    @Override
    public void deleteProposal(Proposal proposal) {
        proposalRepository.deleteProposal(proposal);
    }
}
