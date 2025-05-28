package commonLLDQuestions.rideBooking.repository;

import commonLLDQuestions.rideBooking.entity.Customer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomerRepo {

    private Map<String, Customer> customers;

    private CustomerRepo() {
        this.customers = new ConcurrentHashMap<>();
    }

    private static class Initializer {
        private static final CustomerRepo INSTANCE = new CustomerRepo();
    }

    public static CustomerRepo getInstance(){
        return CustomerRepo.Initializer.INSTANCE;
    }

    public void addCustomer(Customer customer) {
        customers.put(customer.getUserId(),customer);
    }

    public Customer getCustomerById(String customerId) {
        return customers.get(customerId);
    }
}
