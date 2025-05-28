package commonLLDQuestions.rideBooking.service;

import commonLLDQuestions.rideBooking.entity.Customer;
import commonLLDQuestions.rideBooking.repository.CustomerRepo;

import java.util.List;

public class CustomerService {

    private final CustomerRepo customerRepo;


    public CustomerService(){
        this.customerRepo = CustomerRepo.getInstance();
    }

    public synchronized void addCustomer(Customer customer) {
        customerRepo.addCustomer(customer);
    }

    public Customer getCustomerById(String customerId) {
        return customerRepo.getCustomerById(customerId);
    }
}
