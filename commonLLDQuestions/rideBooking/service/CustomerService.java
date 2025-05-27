package commonLLDQuestions.rideBooking.service;

import commonLLDQuestions.rideBooking.repository.CustomerRepo;

public class CustomerService {

    private final CustomerRepo customerRepo;


    public CustomerService(){
        this.customerRepo = CustomerRepo.getInstance();
    }
}
