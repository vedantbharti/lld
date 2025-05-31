package commonLLDQuestions.foodOrdering.repository;

import commonLLDQuestions.foodOrdering.entity.DeliveryPerson;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DeliveryPersonRepo {

    private Map<String, DeliveryPerson> deliveryPersons;

    private DeliveryPersonRepo(){
        this.deliveryPersons = new ConcurrentHashMap<>();
    }

    private static class Initializer {
        private static final DeliveryPersonRepo INSTANCE = new DeliveryPersonRepo();
    }

    public static DeliveryPersonRepo getInstance() {
        return Initializer.INSTANCE;
    }
}
