package org.example.service.Impl;

import org.example.base.BaseRepository;
import org.example.entity.Proposal;
import org.example.repository.ProposalRepository;

import java.util.List;

public class ProposalServiceImpl extends BaseRepository implements ProposalRepository {
    @Override
    public void saveProposal(Proposal proposal) {
        try {
            em.getTransaction().begin();
            em.persist(proposal);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public Proposal getProposalById(Long id) {
        return em.find(Proposal.class, id);
    }

    @Override
    public List<Proposal> getAllProposals() {
        return em.createQuery("SELECT p FROM Proposal  p", Proposal.class).getResultList();
    }

    @Override
    public void updateProposal(Proposal proposal) {
        try {
            em.getTransaction().begin();
            em.merge(proposal);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void deleteProposal(Proposal proposal) {
        try {
            em.getTransaction().begin();
            em.remove(em.contains(proposal) ? proposal : em.merge(proposal));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
}
