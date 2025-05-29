package commonLLDQuestions.foodOrdering.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Coupon {

    private String id;
    private String name;
    private BigDecimal discount;

    public Coupon(String name, BigDecimal discount){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.discount = discount;
    }
}
