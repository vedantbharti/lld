package commonLLDQuestions.foodOrdering.entity;

import commonLLDQuestions.foodOrdering.model.Location;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Customer extends User{

    private Location address;
    private List<String> orderIds;

    public Customer(String customerName){
        super(customerName);
        this.address = null;
        this.orderIds = new ArrayList<>();
    }
}
