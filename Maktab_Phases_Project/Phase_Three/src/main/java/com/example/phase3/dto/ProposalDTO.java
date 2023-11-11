package com.example.phase3.dto;

import com.example.phase3.entity.Proposal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProposalDTO {
    private long id;
    private long orderId;
    private long specialistId;
    private double proposedPrice;
    private Date startTime;
    private int duration;

    public static ProposalDTO fromProposal(Proposal proposal){
        ProposalDTO proposalDTO = new ProposalDTO();
        proposalDTO.setId(proposal.getId());
        proposalDTO.setProposedPrice(proposal.getProposedPrice());
        proposalDTO.setStartTime(proposal.getStartTime());
        proposalDTO.setDuration(proposal.getDuration());
        proposalDTO.setOrderId(proposal.getOrder().getId());
        proposalDTO.setSpecialistId(proposal.getSpecialist().getId());
        return proposalDTO;
    }
}
