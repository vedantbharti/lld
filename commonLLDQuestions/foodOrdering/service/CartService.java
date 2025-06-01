package commonLLDQuestions.foodOrdering.service;

import commonLLDQuestions.foodOrdering.entity.Cart;
import commonLLDQuestions.foodOrdering.entity.Item;
import commonLLDQuestions.foodOrdering.repository.CartRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CartService {

    private final CartRepo cartRepo;
    private final ItemService itemService;

    public CartService() {
        this.cartRepo = CartRepo.getInstance();
        this.itemService = new ItemService();
    }

    public synchronized Cart createCart(String customerId) {
        Cart cart = new Cart(customerId);
        cartRepo.addOrUpdateCart(cart);
        return cart;
    }

    public Cart getCartById(String cartId) {
        return cartRepo.getCartById(cartId);
    }

    public Cart getCartByCustomerId(String customerId) {

        Optional<Cart> cart = cartRepo.getCartByCustomerId(customerId);
        if(cart.isPresent()) return cart.get();
        return null;
    }

    public synchronized Cart addToCart(Item item, String customerId) {
        Cart cart = getCartByCustomerId(customerId);
        if(cart==null) {
            cart = createCart(customerId);
        }
        cart.getItems().add(item.getId());
        cart.setResturantId(item.getRestaurantId());
        cartRepo.addOrUpdateCart(cart);
        return cart;
    }

    public List<Item> getItemsInCart(String cartId) {
        List<String> cartIds = getCartById(cartId).getItems();
        List<Item> items = new ArrayList<>();
        cartIds.stream().forEach(itemId -> items.add(itemService.getItemById(itemId)));
        return items;
    }

    public double getTotalAmount(String cartId) {
        return getCartById(cartId).getTotalCost();
    }

    public synchronized void removeCart(String cartId) {
        cartRepo.removeCart(cartId);
    }


}
