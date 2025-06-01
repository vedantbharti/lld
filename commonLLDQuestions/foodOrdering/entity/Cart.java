package commonLLDQuestions.foodOrdering.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Data
public class Cart {

    private String cartId;
    private String customerId;
    private String resturantId;
    private List<String> items;
    private double totalCost;
    private String selectedCouponId;

    public Cart(String customerId) {
        this.cartId = UUID.randomUUID().toString();
        this.customerId = customerId;
        this.items = Collections.synchronizedList(new ArrayList<>());
        this.totalCost = 0;
        this.selectedCouponId = null;
        this.resturantId = null;
    }
}
