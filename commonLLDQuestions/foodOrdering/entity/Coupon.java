package commonLLDQuestions.foodOrdering.entity;

import commonLLDQuestions.foodOrdering.enums.DiscountType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Coupon {

    private String id;
    private String name;
    private double discount;
    private DiscountType discountType;

    public Coupon(String name, double discount, DiscountType discountType){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.discount = discount;
        this.discountType = discountType;
    }
}
