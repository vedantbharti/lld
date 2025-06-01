package commonLLDQuestions.foodOrdering.repository;

import commonLLDQuestions.foodOrdering.entity.Customer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomerRepo {

    private Map<String, Customer> customers;

    private CustomerRepo(){
        this.customers = new ConcurrentHashMap<>();
    }

    private static class Initializer {
        private static final CustomerRepo INSTANCE = new CustomerRepo();
    }

    public static CustomerRepo getInstance() {
        return Initializer.INSTANCE;
    }

    public synchronized void addOrUpdateCustomer(Customer customer) {
        customers.put(customer.getUserId(),customer);
    }

    public Customer getCustomerById(String customerId) {
        return customers.get(customerId);
    }
}
