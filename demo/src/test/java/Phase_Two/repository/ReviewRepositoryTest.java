package Phase_Two.repository;

import Phase_Two.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private SubServiceRepository subServiceRepository;

    @Autowired
    private OrderRepository orderRepository;



    @Test
    public void testCreateReview(){
        Customer customer = Customer.builder()
                .firstName("amirali")
                .lastName("peymani")
                .email("peymani@gmail.com")
                .password("password")
                .build();

        customerRepository.save(customer);
        Service service = Service.builder()
                .name("testService")
                .build();
        serviceRepository.save(service);
        SubService subService = SubService.builder()
                .service(service)
                .name("testSubService")
                .basePrice(23444)
                .description("test description")
                .build();
        subServiceRepository.save(subService);

        Order order = Order.builder()
                .proposedPrice(234342)
                .jobDescription("doing it right, and in short time")
                .date(new Date())
                .customer(customer)
                .subService(subService)
                .orderStatus(OrderStatus.AWAITING_SPECIALIST_PROPOSAL)
                .build();
        orderRepository.save(order);
        Review review = Review.builder()
                .rating(33)
                .comment("test comment")
                .customer(customer)
                .order(order)
                .build();
        reviewRepository.save(review);
    }

    @Test
    public void testReadReview(){
        Review review = reviewRepository.findById(1L).orElse(null);
        assertNotNull(review);
        System.out.println("review rating: "+ review.getRating() + "review comment: "+
                review.getComment());
    }

    @Test
    public void testUpdateReview(){
        Review review = reviewRepository.findById(1L).orElse(null);
        assertNotNull(review);
        review.setRating(55);
        assertEquals(55, review.getRating());
        reviewRepository.save(review);
    }

    @Test
    public void testDeleteReview(){
        Review review = reviewRepository.findById(1L).orElse(null);
        assertNotNull(review);
        reviewRepository.delete(review);
    }
}