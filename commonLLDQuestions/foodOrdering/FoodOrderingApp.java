package commonLLDQuestions.foodOrdering;

import commonLLDQuestions.foodOrdering.entity.*;
import commonLLDQuestions.foodOrdering.enums.DiscountType;
import commonLLDQuestions.foodOrdering.enums.ItemType;
import commonLLDQuestions.foodOrdering.model.Location;
import commonLLDQuestions.foodOrdering.service.*;

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

        customerService.addCustomer(customer1);
        customerService.addCustomer(customer2);

        customerService.addOrUpdateLocation(customer1.getUserId(),location1);
        customerService.addOrUpdateLocation(customer2.getUserId(),location1);

        //add delivery person

        DeliveryPerson deliveryPerson1 = new DeliveryPerson("deliveryPerson1");
        DeliveryPerson deliveryPerson2 = new DeliveryPerson("deliveryPerson2");

        deliveryPersonService.addDeliveryPerson(deliveryPerson1);
        deliveryPersonService.addDeliveryPerson(deliveryPerson2);

        Location deliveryPersonLocation1 = new Location(1.0,1.0);
        Location deliveryPersonLocation2 = new Location(2.0,2.0);

        deliveryPersonService.addOrUpdateLocation(deliveryPerson1.getUserId(),deliveryPersonLocation1);
        deliveryPersonService.addOrUpdateLocation(deliveryPerson2.getUserId(),deliveryPersonLocation2);

        //add items

        Item item1 = new Item("item1", restaurant1.getId(), 10.0, ItemType.MEAL);
        Item item2 = new Item("item2", restaurant1.getId(), 20.0, ItemType.SNACKS);
        Item item3 = new Item("item3", restaurant2.getId(), 30.0, ItemType.DESSERT);
        Item item4 = new Item("item4", restaurant2.getId(), 40.0, ItemType.SWEETS);

        itemService.addItem(item1);
        itemService.addItem(item2);
        itemService.addItem(item3);
        itemService.addItem(item4);

        //create and add coupon

        Coupon coupon1 = new Coupon("coupon1", 10.0, DiscountType.PERCENTAGE);
        Coupon coupon2 = new Coupon("coupon2", 100.0, DiscountType.AMOUNT);

        couponService.addCoupon(coupon1);
        couponService.addCoupon(coupon2);



    }
}
