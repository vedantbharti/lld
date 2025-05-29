package commonLLDQuestions.foodOrdering.entity;

import commonLLDQuestions.foodOrdering.model.Location;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class Restaurant {

    private String id;
    private String name;
    private List<String> items;
    private Location address;

    public Restaurant(String name, Location address) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.items = new ArrayList<>();
        this.address = address;
    }

}
