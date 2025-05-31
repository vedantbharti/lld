package commonLLDQuestions.foodOrdering.entity;


import commonLLDQuestions.foodOrdering.enums.OrderStatus;
import lombok.Data;

import java.util.UUID;

@Data
public class Order {

    private String orderId;
    private Cart cart;
    private String restaurantId;
    private String customerId;
    private OrderStatus orderStatus;
    private double totalCost;

    public Order(String customerId, String restaurantId, Cart cart, double totalCost) {
        this.orderId = UUID.randomUUID().toString();
        this.cart = cart;
        this.totalCost = totalCost;
        this.restaurantId = restaurantId;
        this.customerId = customerId;
        this.orderStatus = OrderStatus.PROCESSING;
    }
}
