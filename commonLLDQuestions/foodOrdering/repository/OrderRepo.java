package commonLLDQuestions.foodOrdering.repository;


import commonLLDQuestions.foodOrdering.entity.Order;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OrderRepo {

    private Map<String, Order> orders;

    private OrderRepo(){
        this.orders = new ConcurrentHashMap<>();
    }

    private static class Initializer {
        private static final OrderRepo INSTANCE = new OrderRepo();
    }

    public static OrderRepo getInstance() {
        return Initializer.INSTANCE;
    }

    public synchronized void addOrUpdateOrder(Order order) {
        orders.put(order.getOrderId(),order);
    }
}
