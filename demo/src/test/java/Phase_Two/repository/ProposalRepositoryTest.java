package Phase_Two.repository;

import Phase_Two.entity.*;
import org.hibernate.type.descriptor.java.CalendarTimeJavaType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import java.time.Month;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ProposalRepositoryTest {

    @Autowired
    private ProposalRepository proposalRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private SubServiceRepository subServiceRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private SpecialistRepository specialistRepository;

    @Test
    public void testCreateProposal(){
        Service service = Service.builder()
                .name("service")
                .build();
        serviceRepository.save(service);
        SubService subService = SubService.builder()
                .service(service)
                .description("test description")
                .basePrice(33434)
                .name("base price")
                .build();
        subServiceRepository.save(subService);
        Specialist specialist = Specialist.builder()
                .firstName("John")
                .lastName("Johnny")
                .email("john@gmail.com")
                .password("abc123")
                .specialistStatus(SpecialistStatus.CONFIRM)
                .subServices(List.of(subService))
                .build();
        specialistRepository.save(specialist);
        Customer customer = Customer.builder()
                .firstName("Jones")
                .lastName("peymani")
                .email("peyman@gmail.com")
                .password("23434343")
                .build();
        customerRepository.save(customer);
        Order order = Order.builder()
                .proposedPrice(234342)
                .jobDescription("doing it right, and in short time")
                .date(new Date())
                .customer(customer)
                .subService(subService)
                .orderStatus(OrderStatus.AWAITING_SPECIALIST_PROPOSAL)
                .build();
        orderRepository.save(order);
        Proposal proposal = Proposal.builder()
                .specialist(specialist)
                .proposedPrice(23443)
                .startTime(new Date(2023, 3,4))
                .order(order)
                .duration(3)
                .build();
        if (proposal.getStartTime().after(order.getDate()) && specialist.getSpecialistStatus() == SpecialistStatus.CONFIRM &&
        proposal.getProposedPrice() <= order.getProposedPrice()) {
            proposalRepository.save(proposal);
        } else {
            fail("fail to save proposal");
        }
    }

    @Test
    public void testMakingProposal(){
        Specialist specialist = specialistRepository.getSpecialistByEmailAndPassword("", "");
        if (specialist.getSpecialistStatus() == SpecialistStatus.CONFIRM) {
            Order order = orderRepository.findById(1L).orElse(null);
            assertNotNull(order);
            Proposal proposal = Proposal.builder()
                    .specialist(specialist)
                    .proposedPrice(23443)
                    .startTime(new Date(2023, 12,4))
                    .order(order)
                    .duration(3)
                    .build();
            if (proposal.getStartTime().after(order.getDate()) && proposal.getProposedPrice()<=
            order.getProposedPrice()){
                proposalRepository.save(proposal);
                order.setOrderStatus(OrderStatus.AWAITING_SPECIALIST_SELECTION);
            } else {
                System.out.println("failed to save proposal");
            }
        }
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