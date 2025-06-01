package commonLLDQuestions.foodOrdering.service;

import commonLLDQuestions.foodOrdering.entity.Order;
import commonLLDQuestions.foodOrdering.repository.OrderRepo;

public class OrderService {

    private final OrderRepo orderRepo;

    public OrderService(){
        this.orderRepo = OrderRepo.getInstance();
    }

    public synchronized void addOrUpdateOrder(Order order) {
        orderRepo.addOrUpdateOrder(order);
    }
}
