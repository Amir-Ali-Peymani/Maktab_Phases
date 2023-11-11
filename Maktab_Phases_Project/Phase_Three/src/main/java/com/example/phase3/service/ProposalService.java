package com.example.phase3.service;

import com.example.phase3.dto.ProposalDTO;
import com.example.phase3.entity.Proposal;
import com.example.phase3.exception.AuthenticationNotFoundException;
import com.example.phase3.exception.NullPointerException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProposalService {

    void saveProposal(Proposal proposal) throws NullPointerException;

    ProposalDTO getProposalById(Long id) throws AuthenticationNotFoundException;

    List<ProposalDTO> getAllProposals();

    void updateProposal(long id, Proposal proposal) throws NullPointerException;

    void deleteProposal(long id) throws AuthenticationNotFoundException;
}
