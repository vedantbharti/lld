package commonLLDQuestions.foodOrdering.service;

import commonLLDQuestions.foodOrdering.entity.Customer;
import commonLLDQuestions.foodOrdering.model.Location;
import commonLLDQuestions.foodOrdering.repository.CustomerRepo;

public class CustomerService {

    private final CustomerRepo customerRepo;

    public CustomerService(){
        this.customerRepo = CustomerRepo.getInstance();
    }

    public synchronized void addOrUpdateCustomer(Customer customer){
        customerRepo.addOrUpdateCustomer(customer);
    }

    public Customer getCustomerById(String customerId) {
        return customerRepo.getCustomerById(customerId);
    }

    public synchronized void addOrUpdateLocation(String customerId, Location location) {
        Customer customer = getCustomerById(customerId);
        customer.setAddress(location);
        addOrUpdateCustomer(customer);
    }
}
