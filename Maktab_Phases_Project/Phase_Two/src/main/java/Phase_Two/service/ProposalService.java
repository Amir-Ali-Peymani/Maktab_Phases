package Phase_Two.service;

import Phase_Two.entity.Order;
import Phase_Two.entity.Proposal;
import Phase_Two.entity.Specialist;

import java.util.List;

public interface ProposalService {

    void saveProposal(Proposal proposal);

    Proposal getProposalById(Long id);

    Proposal getProposalByOrderAndSpecialist(Order order, Specialist specialist);

    List<Proposal> getAllProposals();

    void updateProposal(Proposal proposal);

    void deleteProposal(Proposal proposal);
}
