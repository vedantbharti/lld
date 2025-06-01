package commonLLDQuestions.foodOrdering;

import commonLLDQuestions.foodOrdering.entity.*;
import commonLLDQuestions.foodOrdering.enums.DiscountType;
import commonLLDQuestions.foodOrdering.enums.ItemType;
import commonLLDQuestions.foodOrdering.enums.PaymentStatus;
import commonLLDQuestions.foodOrdering.model.Location;
import commonLLDQuestions.foodOrdering.service.*;

import java.util.List;

public class FoodOrderingApp {

    private static CartService cartService;
    private static CouponService couponService;
    private static CustomerService customerService;
    private static DeliveryPersonService deliveryPersonService;
    private static ItemService itemService;
    private static OrderService orderService;
    private static PaymentService paymentService;
    private static RestaurantService restaurantService;

    private static void initialize() {
        cartService = new CartService();
        couponService = new CouponService();
        customerService = new CustomerService();
        deliveryPersonService = new DeliveryPersonService();
        itemService = new ItemService();
        orderService = new OrderService();
        paymentService = new PaymentService();
        restaurantService = new RestaurantService();
    }

    public static void main(String[] args) {

        initialize();

        //haven't implemented the search feature here...can be done by some methods
        //Also, haven't used strategies for payment...can check other implementations for that

        //add restaurants
        Location location1 = new Location(1.0,1.0);
        Location location2 = new Location(2.0,2.0);

        Restaurant restaurant1 = new Restaurant("restaurant1", location1);
        Restaurant restaurant2 = new Restaurant("restaurant2", location2);

        restaurantService.addRestaurant(restaurant1);
        restaurantService.addRestaurant(restaurant2);

        //add customer
        Location customerLocation1 = new Location(1.0,2.0);
        Location customerLocation2 = new Location(2.0,1.0);

        Customer customer1 = new Customer("customer1");
        Customer customer2 = new Customer("customer2");

        customerService.addOrUpdateCustomer(customer1);
        customerService.addOrUpdateCustomer(customer2);

        customerService.addOrUpdateLocation(customer1.getUserId(),location1);
        customerService.addOrUpdateLocation(customer2.getUserId(),location1);

        //add delivery person

        DeliveryPerson deliveryPerson1 = new DeliveryPerson("deliveryPerson1");
        DeliveryPerson deliveryPerson2 = new DeliveryPerson("deliveryPerson2");

        deliveryPersonService.addOrUpdateDeliveryperson(deliveryPerson1);
        deliveryPersonService.addOrUpdateDeliveryperson(deliveryPerson2);

        Location deliveryPersonLocation1 = new Location(1.0,1.0);
        Location deliveryPersonLocation2 = new Location(2.0,2.0);

        deliveryPersonService.addOrUpdateLocation(deliveryPerson1.getUserId(),deliveryPersonLocation1);
        deliveryPersonService.addOrUpdateLocation(deliveryPerson2.getUserId(),deliveryPersonLocation2);

        //add items

        Item item1 = new Item("item1", restaurant1.getId(), 10.0, ItemType.MEAL);
        Item item2 = new Item("item2", restaurant1.getId(), 20.0, ItemType.SNACKS);
        Item item3 = new Item("item3", restaurant2.getId(), 30.0, ItemType.DESSERT);
        Item item4 = new Item("item4", restaurant2.getId(), 40.0, ItemType.SWEETS);

        itemService.addOrUpdateItem(item1);
        itemService.addOrUpdateItem(item2);
        itemService.addOrUpdateItem(item3);
        itemService.addOrUpdateItem(item4);

        //create and add coupon

        Coupon coupon1 = new Coupon("coupon1", 10.0, DiscountType.PERCENTAGE);
        Coupon coupon2 = new Coupon("coupon2", 100.0, DiscountType.AMOUNT);

        couponService.addOrUpdateCoupon(coupon1);
        couponService.addOrUpdateCoupon(coupon2);

        //add item to the cart
        Cart cart = cartService.addToCart(item1,customer1.getUserId());
        List<Item> items = cartService.getItemsInCart(cart.getCartId());

        //make payment
        double totalAmount = cartService.getTotalAmount(cart.getCartId());
        Payment payment = paymentService.makePayment(customer1.getUserId(), totalAmount);

        if(payment.getPaymentStatus().equals(PaymentStatus.COMPLETED)) {
            //create order and clear cart
            Cart userCart = cartService.getCartByCustomerId(customer1.getUserId());
            Order order1 = new Order(customer1.getUserId(),userCart.getResturantId(),payment.getPaymentId(),payment.getAmount());
            orderService.addOrUpdateOrder(order1);
            cartService.removeCart(cart.getCartId());

            System.out.println("Payment successful and order placed!");
            System.out.println("order details: " + order1.getOrderId() + " " + order1.getOrderStatus() + " " + order1.getCustomerId() + " " + order1.getRestaurantId());
        } else if(payment.getPaymentStatus().equals(PaymentStatus.FAILED)){
            System.out.println("Payment failed. Please try again");
        }
    }
}
