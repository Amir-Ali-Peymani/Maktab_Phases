package org.example.repository.Impl;

import jakarta.persistence.TypedQuery;
import org.example.base.BaseRepository;
import org.example.entity.Order;
import org.example.entity.Proposal;
import org.example.entity.Specialist;
import org.example.repository.ProposalRepository;

import java.util.List;

public class ProposalRepositoryImpl extends BaseRepository implements ProposalRepository {
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
    public Proposal getProposalByOrderAndSpecialist(Order order, Specialist specialist) {
        String jpql = "SELECT p FROM Proposal p WHERE p.order = :order AND p.specialist = :specialist";
        TypedQuery<Proposal> query = em.createQuery(jpql, Proposal.class);
        query.setParameter("order", order);
        query.setParameter("specialist", specialist);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
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
