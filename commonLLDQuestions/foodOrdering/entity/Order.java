package commonLLDQuestions.foodOrdering.entity;


import commonLLDQuestions.foodOrdering.enums.OrderStatus;
import commonLLDQuestions.foodOrdering.model.Cart;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Order {

    private String orderId;
    private Cart cart;
    private String restaurantId;
    private String customerId;
    private OrderStatus orderStatus;

    public Order(String customerId, String restaurantId, Cart cart) {
        this.orderId = UUID.randomUUID().toString();
        this.cart = cart;
        this.restaurantId = restaurantId;
        this.customerId = customerId;
        this.orderStatus = OrderStatus.PROCESSING;
    }
}
