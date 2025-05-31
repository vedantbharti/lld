package commonLLDQuestions.foodOrdering.entity;

import commonLLDQuestions.foodOrdering.enums.ItemType;
import lombok.Data;

import java.util.UUID;

@Data
public class Item {

    private String id;
    private String name;
    private String restaurantId;
    private double price;
    private ItemType itemType;

    public Item(String name, String restaurantId, double price, ItemType itemType) {
        this.id = UUID.randomUUID().toString();
        this.restaurantId = restaurantId;
        this.name = name;
        this.price = price;
        this.itemType = itemType;
    }
}
