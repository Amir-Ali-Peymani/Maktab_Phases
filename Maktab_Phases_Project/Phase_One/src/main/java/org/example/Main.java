package org.example;

import org.example.entity.*;
import org.example.util.ServiceLocator;

import java.util.*;



public class Main {
    public static void main(String[] args) {
        specialistSignIn() ;
    }

    private static void addingServices() {
        Service service = new Service();
        service.setName("Service Name");

        Set<String> addedServices = new HashSet<>();
        List<Service> services = ServiceLocator.getServiceService().getAllServices();

        for (Service loopService : services) {
            addedServices.add(loopService.getName());
        }

        if (addedServices.contains(service.getName())) {
            System.out.println("This service already exists in the database.");
        } else {
            ServiceLocator.getServiceService().saveService(service);
            System.out.println("Service added to the database.");
        }
    }

    private static void addingSubService() {
        Service service = ServiceLocator.getServiceService().getServiceByName("Service Name");
        SubService subService = new SubService();
        subService.setName("Sub-Service 1");
        subService.setBasePrice(23000);
        subService.setDescription("Description for Sub-Service");
        subService.setService(service);

        Set<String> addedSubServices = new HashSet<>();
        List<SubService> subServiceList = ServiceLocator.getSubServiceService().getAllSubServices();

        for (SubService subServiceLoop : subServiceList) {
            addedSubServices.add(subServiceLoop.getName());
        }
        if (addedSubServices.contains(subService.getName())) {
            System.out.println("This Sub-Service already exists in the database.");
        } else {
            ServiceLocator.getSubServiceService().saveSubService(subService);
            System.out.println("Sub-Service added to the database.");
        }
    }

    private static void signInAdmin() {
        List<Admin> admins = ServiceLocator.getAdminService().getAllAdmin();
        for (Admin admin : admins) {
            if (admin.getEmail().equals("john.doe@example.com") && admin.getPassword().equals("password123")) {
                System.out.println("you have log in successfully");
            } else {
                System.out.println(" you have failed to signIn");
            }
        }
    }

    private static void customerSignIn() {
        List<Customer> customers = ServiceLocator.getCustomerService().getAllCustomer();
        boolean loginSuccessful = false;
        Customer loggedInCustomer = null;
        for (Customer customer : customers) {
            if (customer.getEmail().equals("amirali@gmail.com") && customer.getPassword().equals("1234")) {
                System.out.println("You have logged in successfully");
                loginSuccessful = true;
                loggedInCustomer = customer;
                break;
            }
        }

        if (!loginSuccessful) {
            System.out.println("Login failed. Please check your email and password.");
        } else {
//            makeOrder(loggedInCustomer);
            // fullFillCredit(loggedInCustomer);
            chooseOrderProposal(loggedInCustomer);
        }
    }

    private static void specialistSignIn() {
        List<Specialist> specialists = ServiceLocator.getSpecialtyService().getAllSpecialists();
        Specialist loggedInSpecialist = null;

        for (Specialist specialist : specialists) {
            if (specialist.getEmail().equals("mamad@gmail.com") && specialist.getPassword().equals("234223424")) {
                System.out.println("You have logged in successfully");
                loggedInSpecialist = specialist;
                break;
            }
        }

        if (loggedInSpecialist != null && loggedInSpecialist.getSpecialistStatus() == SpecialistStatus.CONFIRM ) {
//            specialistSubServiceChoose(loggedInSpecialist);
//            specialistProposal(loggedInSpecialist);
            chooseOrderSpecialist(loggedInSpecialist);
        } else {
            System.out.println("Invalid login.");
        }
    }

    private static void customerSignUp() {
        Customer customer = new Customer();
        customer.setEmail("amirali@gmail.com");
        customer.setFirstName("Amir ali");
        customer.setLastName("Peymani");
        customer.setPassword("1234");

        Set<String> addedCustomer = new HashSet<>();
        List<Customer> customerList = ServiceLocator.getCustomerService().getAllCustomer();

        for (Customer customerLoop : customerList) {
            addedCustomer.add(customerLoop.getEmail());
        }
        if (addedCustomer.contains(customer.getEmail())) {
            System.out.println("this customer already exists");
        } else {
            ServiceLocator.getCustomerService().saveCustomer(customer);
            System.out.println("Customer added to the database");
        }
    }

    private static void makeOrder(Customer customer) {
        SubService subService = ServiceLocator.getSubServiceService().getSubServiceByName("Sub-Service 1");
        List<Order> orders = ServiceLocator.getOrderService().getOrdersByCustomerAndSubService(customer, subService);
        if (orders.isEmpty()) {
            Order order = new Order();
            order.setProposedPrice(123.12);
            order.setJobDescription("I want someone who can do the job");
            Date currentDate = new Date();
            order.setDate(currentDate);
            if (order.getSpecialist() == null) {
                order.setOrderStatus(OrderStatus.AWAITING_SPECIALIST_PROPOSAL);
            }
            order.setSubService(subService);
            order.setCustomer(customer);

            ServiceLocator.getOrderService().saveOrder(order);
            System.out.println("Order added to the database.");
        } else {
            System.out.println("This order already exists in the table.");
        }
    }

    private static void fullFillCredit(Customer customer) {
        List<Credit> credits = ServiceLocator.getCreditService().getAllCredit();
        boolean customerHasCredit = false;

        for (Credit creditLoop : credits) {
            if (creditLoop.getCustomer().equals(customer)) {
                System.out.println("This customer already has credit.");
                customerHasCredit = true;
                break;
            }
        }

        if (!customerHasCredit) {
            Credit credit = new Credit();
            credit.setBalance(100.0);
            credit.setCustomer(customer);
            ServiceLocator.getCreditService().saveCredit(credit);
            System.out.println("Credit added for the customer.");
        }
    }

    private static void writeReview(Customer customer) {
        Review review = new Review();
        review.setComment("it was very good the price was adequate");
        review.setRating(10);
        ServiceLocator.getReviewService().saveReview(review);

    }

    private static void enrollSpecialist() {
        Specialist specialist = new Specialist();
        specialist.setFirstName("mamad");
        specialist.setLastName("hoseiny");
        specialist.setEmail("mamad@gmail.com");
        specialist.setPassword("234223424");
        specialist.setSpecialistStatus(SpecialistStatus.NEW);

        Set<String> addedSpecialist = new HashSet<>();
        List<Specialist> specialistsList = ServiceLocator.getSpecialtyService().getAllSpecialists();

        for (Specialist specialistLoop : specialistsList) {
            addedSpecialist.add(specialistLoop.getEmail());
        }
        if (addedSpecialist.contains(specialist.getEmail())) {
            System.out.println("this specialist already exists");
        } else {
            ServiceLocator.getSpecialtyService().saveSpecialist(specialist);
            System.out.println("specialist added to the database");
        }
    }

    private static void specialistStatus() {
        List<Specialist> listSpecialist = ServiceLocator.getSpecialtyService().getAllSpecialists();
        for (Specialist specialist : listSpecialist) {
            System.out.println("Id = " + specialist.getId() + "|" +
                    "email = " + specialist.getEmail() + "|" + "name = " + specialist.getFirstName()
                    + "|" + "last name = " + specialist.getLastName());
        }
        Specialist specialist = ServiceLocator.getSpecialtyService().getSpecialistById(1L);
        specialist.setSpecialistStatus(SpecialistStatus.CONFIRM);
        ServiceLocator.getSpecialtyService().updateSpecialist(specialist);
        System.out.println("the specialist status changed to the " + specialist.getSpecialistStatus());
    }

    private static void specialistSubServiceChoose(Specialist specialist) {
        if (specialist.getSubService() != null) {
            System.out.println("you have already chosen the sub-service which is: "
                    + specialist.getSubService().getName());
            return;
        }
        List<SubService> availableSubServices = ServiceLocator.getSubServiceService().getAllSubServices();
        System.out.println("available sub-services: ");
        for (SubService subServiceLoop : availableSubServices) {
            System.out.println(subServiceLoop.getId() + ":" + subServiceLoop.getName());
        }
        long chosenSubService = 1L;
        SubService selectedSubService = ServiceLocator.getSubServiceService().getSubServiceById(chosenSubService);
        if (selectedSubService != null) {
            specialist.setSubService(selectedSubService);
            ServiceLocator.getSpecialtyService().updateSpecialist(specialist);
            System.out.println("Specialist " + specialist.getId() + " has chosen the sub-service: " +
                    selectedSubService.getName());
        } else {
            System.out.println("Invalid sub-service choice. Please choose from the available sub-services.");
        }
    }

    private static void specialistProposal(Specialist specialist) {
        SubService specialistSubService = specialist.getSubService();
        List<Order> ordersForSpecialistSubService = ServiceLocator.getOrderService().getOrderBySubService(specialistSubService);

        if (ordersForSpecialistSubService.isEmpty()) {
            System.out.println("No orders available for the specialist's sub-service.");
        } else {
            System.out.println("Available Orders for Specialist's Sub-Service:");
            for (Order order : ordersForSpecialistSubService) {
                System.out.println("ID of order: " + order.getId() +"||"
                 + "Customer Name: " + order.getCustomer().getFirstName()+"||"
                 + "Proposed Price: " + order.getProposedPrice()+"||"
                 + "Job description: " + order.getJobDescription()+"||"
                 + "Date: " + order.getDate());
            }
        }

        Order selectedOrder = ServiceLocator.getOrderService().getOrderById(3L);
        Proposal existingProposal = ServiceLocator.getProposalService().getProposalByOrderAndSpecialist(selectedOrder, specialist);

        if (existingProposal != null) {
            System.out.println("A proposal for this order already exists.");
        } else {
            Proposal proposal = new Proposal();
            proposal.setOrder(selectedOrder);
            proposal.setSpecialist(specialist);
            proposal.setProposedPrice(233.3);
            proposal.setStartTime(new Date());
            proposal.setDuration(3);
            ServiceLocator.getProposalService().saveProposal(proposal);
            System.out.println("Proposal created and saved successfully.");
        }
    }

    private static void chooseOrderProposal(Customer customer){
        Set<Order> orders = customer.getOrders();
        for (Order order : orders){
            System.out.println("customer orders: ");
            System.out.println(order.getId() + "__" + order.getProposedPrice() + "__" + order.getJobDescription());
        }
        Order order = ServiceLocator.getOrderService().getOrderById(3L);
        List<Proposal> proposals = ServiceLocator.getProposalService().getAllProposals();
        for (Proposal proposal : proposals){
            System.out.println("Proposal: ");
            System.out.println(proposal.getId() + "__" + proposal.getProposedPrice() + "__" + proposal.getDuration());
        }
        Proposal chosenProposal = ServiceLocator.getProposalService().getProposalById(3L);
        order.setSpecialist(chosenProposal.getSpecialist());
        order.setFinalPrice(chosenProposal.getProposedPrice());
        Calendar cal = Calendar.getInstance();
        cal.setTime(chosenProposal.getStartTime());
        cal.add(Calendar.DAY_OF_MONTH, chosenProposal.getDuration());
        Date finishDate = cal.getTime();
        order.setCompeletionDate(finishDate);
        order.setOrderStatus(OrderStatus.AWAITING_SPECIALIST_SELECTION);
        ServiceLocator.getOrderService().updateOrder(order);
    }

    private static void chooseOrderSpecialist(Specialist specialist){
        List<Proposal> proposals = specialist.getProposals();
        for (Proposal proposal : proposals){
            System.out.println("proposals that has chosen by the customer:");
            if (proposal.getOrder() != null){
                System.out.println(proposal.getOrder().getId() + " " + proposal.getOrder().getFinalPrice()
                        + proposal.getOrder().getCustomer().getFirstName());
            }
        }
        Proposal chosenProposal = ServiceLocator.getProposalService().getProposalById(3L);
        specialist.setOrders(chosenProposal.getSpecialist().getOrders());
        List<Order> orders = specialist.getOrders();
        for (Order order : orders){
            System.out.println(order.getCustomer().getFirstName());
            if (chosenProposal.getOrder() == order){
                order.setOrderStatus(OrderStatus.STARTED);
            }
        }
        ServiceLocator.getSpecialtyService().updateSpecialist(specialist);
    }


}




