package com.example.demo.repository;

import com.example.demo.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProposalRepositoryTest {

    @Autowired
    private ProposalRepository proposalRepository;

    @Test
    public void testCreateProposal(){
        Service service = Service.builder()
                .name("test service")
                .build();

        SubService subService = SubService.builder()
                .service(service)
                .description("test description")
                .basePrice(33434)
                .name("test base price")
                .build();

        Specialist specialist = Specialist.builder()
                .firstName("John")
                .lastName("Johnny")
                .email("john@gmail.com")
                .password("abc123")
                .subServices(List.of(subService))
                .build();

        Customer customer = Customer.builder()
                .firstName("Jones")
                .lastName("peymani")
                .email("peyman@gmail.com")
                .password("23434343")
                .build();

        Order order = Order.builder()
                .proposedPrice(234342)
                .jobDescription("doing it right, and in short time")
                .date(new Date())
                .customer(customer)
                .subService(subService)
                .orderStatus(OrderStatus.AWAITING_SPECIALIST_PROPOSAL)
                .build();

        Proposal proposal = Proposal.builder()
                .specialist(specialist)
                .proposedPrice(23443)
                .startTime(new Date(2023, Calendar.DECEMBER, 3))
                .order(order)
                .duration(3)
                .build();

        proposalRepository.save(proposal);
    }

    @Test
    public void testReadProposal(){
        Proposal proposal = proposalRepository.findById(2L).orElse(null);
        assertNotNull(proposal);
        System.out.println("Proposal price:"+ proposal.getProposedPrice()+
                "Proposal date:" + proposal.getDuration());
    }

    @Test
    public void testUpdateProposal(){
        Proposal proposal = proposalRepository.findById(2L).orElse(null);
        assertNotNull(proposal);
        proposal.setDuration(45);
        assertEquals(45, proposal.getDuration());
        proposalRepository.save(proposal);
    }

    @Test
    public void testDeleteProposal(){
        Proposal proposal = proposalRepository.findById(2L).orElse(null);
        assertNotNull(proposal);
        proposalRepository.delete(proposal);
    }



}