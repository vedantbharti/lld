package commonLLDQuestions.foodOrdering.entity;

import commonLLDQuestions.foodOrdering.model.Location;
import lombok.Data;

@Data
public class DeliveryPerson extends User{

    private Location currentLocaton;
    private boolean isAvailable;

    public DeliveryPerson(String name) {
        super(name);
        this.currentLocaton = null;
        this.isAvailable = true;
    }
}
