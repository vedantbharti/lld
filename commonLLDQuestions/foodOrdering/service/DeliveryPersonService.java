package commonLLDQuestions.foodOrdering.service;

import commonLLDQuestions.foodOrdering.entity.Customer;
import commonLLDQuestions.foodOrdering.entity.DeliveryPerson;
import commonLLDQuestions.foodOrdering.model.Location;
import commonLLDQuestions.foodOrdering.repository.DeliveryPersonRepo;

public class DeliveryPersonService {

    private final DeliveryPersonRepo deliveryPersonRepo;

    public DeliveryPersonService() {
        this.deliveryPersonRepo = DeliveryPersonRepo.getInstance();
    }

    public synchronized void addOrUpdateDeliveryperson(DeliveryPerson deliveryPerson){
        deliveryPersonRepo.addOrUpdateDeliveryperson(deliveryPerson);
    }

    public DeliveryPerson getDeliveryPersonById(String customerId) {
        return deliveryPersonRepo.getDeliveryPersonById(customerId);
    }

    public synchronized void addOrUpdateLocation(String deliverypersonId, Location location) {
        DeliveryPerson deliveryPerson = getDeliveryPersonById(deliverypersonId);
        deliveryPerson.setCurrentLocaton(location);
        addOrUpdateDeliveryperson(deliveryPerson);
    }
}
