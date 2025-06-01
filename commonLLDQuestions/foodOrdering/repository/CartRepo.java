package commonLLDQuestions.foodOrdering.repository;

import commonLLDQuestions.foodOrdering.entity.Cart;

import java.util.Map;
import java.util.Optional;
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

    public synchronized void addOrUpdateCart(Cart cart) {
        carts.put(cart.getCartId(),cart);
    }

    public Cart getCartById(String cartId) {
        return carts.get(cartId);
    }

    public Optional<Cart> getCartByCustomerId(String customerId) {
        return carts.values().stream().filter(cart -> cart.getCustomerId().equals(customerId)).findAny();
    }

    public synchronized void removeCart(String cartId) {
        carts.remove(cartId);
    }
}
