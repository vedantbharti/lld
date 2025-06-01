package commonLLDQuestions.foodOrdering.service;

import commonLLDQuestions.foodOrdering.entity.Coupon;
import commonLLDQuestions.foodOrdering.repository.CouponRepo;

public class CouponService {

    private final CouponRepo couponRepo;

    public CouponService() {
        this.couponRepo = CouponRepo.getInstance();
    }

    public synchronized void addOrUpdateCoupon(Coupon coupon) {
        couponRepo.addOrUpdateCoupon(coupon);
    }
}
