package com.example.phase3.service.Impl;

import com.example.phase3.entity.Proposal;
import com.example.phase3.exception.AuthenticationNotFoundException;
import com.example.phase3.exception.NullPointerException;
import com.example.phase3.repository.ProposalRepository;
import com.example.phase3.service.ProposalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProposalServiceImpl implements ProposalService {

    private final ProposalRepository proposalRepository;

    @Override
    public void saveProposal(Proposal proposal) throws NullPointerException {
        if (proposal == null || proposal.getSpecialist() == null) {
            throw new NullPointerException();
        }
        proposalRepository.save(proposal);
    }

    @Override
    public Proposal getProposalById(Long id) throws AuthenticationNotFoundException {
        Proposal proposal = proposalRepository.getProposalById(id);
        if (proposal == null) {
            throw new AuthenticationNotFoundException();
        }
        return proposal;
    }

    @Override
    public List<Proposal> getAllProposals() {
        return proposalRepository.findAll();
    }

    @Override
    public void updateProposal(long id, Proposal proposal) throws NullPointerException {
        Proposal proposalUpdate = proposalRepository.getProposalById(id);
        if (proposalUpdate == null) {
            throw new NullPointerException();
        }
        proposalUpdate.setProposedPrice(proposal.getProposedPrice());
        proposalRepository.save(proposalUpdate);
    }

    @Override
    public void deleteProposal(long id) throws AuthenticationNotFoundException {
        Proposal proposal = proposalRepository.getProposalById(id);
        if (proposal == null) {
            throw new AuthenticationNotFoundException();
        }
        proposalRepository.delete(proposal);
    }
}
