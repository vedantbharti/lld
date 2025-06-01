package commonLLDQuestions.foodOrdering.entity;


import commonLLDQuestions.foodOrdering.enums.OrderStatus;
import lombok.Data;

import java.util.UUID;

@Data
public class Order {

    private String orderId;
    private String restaurantId;
    private String customerId;
    private String paymentId;
    private OrderStatus orderStatus;
    private double totalCost;

    public Order(String customerId, String restaurantId, String paymentId, double totalCost) {
        this.orderId = UUID.randomUUID().toString();
        this.totalCost = totalCost;
        this.restaurantId = restaurantId;
        this.customerId = customerId;
        this.orderStatus = OrderStatus.PROCESSING;
    }
}
