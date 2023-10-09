package org.example.util;

import org.example.repository.*;
import org.example.repository.Impl.*;
import org.example.service.*;
import org.example.service.Impl.*;

public class ServiceLocator {

    private static final AdminRepository adminRepository = new AdminRepositoryImpl();

    private static final AdminService adminService = new AdminServiceImpl(adminRepository);

    private static final CreditRepository creditRepository = new CreditRepositoryImpl();

    private static final CreditService creditService = new CreditServiceImpl(creditRepository);

    private static final CustomerRepository customerRepository = new CustomerRepositoryImpl();

    private static final CustomerService customerService = new CustomerServiceImpl(customerRepository);

    private static final OrderRepository orderRepository = new OrderRepositoryImpl();

    private static final OrderService orderService = new OrderServiceImpl(orderRepository);

    private static final ProposalRepository proposalRepository = new ProposalRepositoryImpl();

    private static final ProposalService proposalService = new ProposalServiceImpl(proposalRepository);

    private static final ReviewRepository reviewRepository = new ReviewRepositoryImpl();

    private static final ReviewService reviewService = new ReviewServiceImpl(reviewRepository);

    private static final ServiceRepository serviceRepository = new ServiceRepositoryImpl();

    private static final ServiceService serviceService = new ServiceServiceImpl(serviceRepository);

    private static final SpecialistRepository specialistRepository = new SpecialistRepositoryImpl();

    private static final SpecialistService specialistService = new SpecialistServiceImpl(specialistRepository);

    private static final SubServiceRepository subServiceRepository = new SubServiceRepositoryImpl();

    private static final SubServiceService subServiceService = new SubServiceServiceImpl(subServiceRepository);

    public static AdminService getAdminService() {
        return adminService;
    }

    public static CreditService getCreditService() {
        return creditService;
    }

    public static CustomerService getCustomerService() {
        return customerService;
    }

    public static OrderService getOrderService(){
        return orderService;
    }

    public static ProposalService getProposalService() {
        return proposalService;
    }

    public static ReviewService getReviewService() {
        return reviewService;
    }

    public static ServiceService getServiceService() {
        return serviceService;
    }

    public static SpecialistService getSpecialtyService() {
        return specialistService;
    }

    public static SubServiceService getSubServiceService() {
        return subServiceService;
    }
}
