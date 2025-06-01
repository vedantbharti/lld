package commonLLDQuestions.foodOrdering.repository;

import commonLLDQuestions.foodOrdering.entity.Coupon;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CouponRepo {

    private Map<String, Coupon> coupons;

    private CouponRepo(){
        this.coupons = new ConcurrentHashMap<>();
    }

    private static class Initializer {
        private static final CouponRepo INSTANCE = new CouponRepo();
    }

    public static CouponRepo getInstance() {
        return Initializer.INSTANCE;
    }

    public synchronized void addOrUpdateCoupon(Coupon coupon) {
        coupons.put(coupon.getId(),coupon);
    }
}
