package commonLLDQuestions.foodOrdering.entity;

import commonLLDQuestions.foodOrdering.enums.FoodType;
import lombok.Data;

import java.util.UUID;

@Data
public class Item {

    private String id;
    private String name;
    private double price;
    private FoodType foodType;

    public Item(String name, double price, FoodType foodType) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.foodType = foodType;
    }
}
