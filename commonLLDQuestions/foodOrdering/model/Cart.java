package commonLLDQuestions.foodOrdering.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class Cart {

    private List<String> items;
    private double totalCost;
    private String selectedCouponId;

    public Cart() {
        this.items = Collections.synchronizedList(new ArrayList<>());
        this.totalCost = 0;
        this.selectedCouponId = null;
    }
}
