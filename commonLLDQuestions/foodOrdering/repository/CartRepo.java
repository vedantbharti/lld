package commonLLDQuestions.foodOrdering.repository;

import commonLLDQuestions.foodOrdering.entity.Cart;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CartRepo {

    private Map<String, Cart> carts;

    private CartRepo(){
        this.carts = new ConcurrentHashMap<>();
    }

    private static class Initializer {
        private static final CartRepo INSTANCE = new CartRepo();
    }

    public static CartRepo getInstance() {
        return Initializer.INSTANCE;
    }
}
