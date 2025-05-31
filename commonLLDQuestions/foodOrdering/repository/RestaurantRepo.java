package commonLLDQuestions.foodOrdering.repository;

import commonLLDQuestions.foodOrdering.entity.Restaurant;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RestaurantRepo {

    private Map<String, Restaurant> restaurants;

    private RestaurantRepo(){
        this.restaurants = new ConcurrentHashMap<>();
    }

    private static class Initializer {
        private static final RestaurantRepo INSTANCE = new RestaurantRepo();
    }

    public static RestaurantRepo getInstance() {
        return Initializer.INSTANCE;
    }
}
