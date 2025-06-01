package commonLLDQuestions.foodOrdering.service;

import commonLLDQuestions.foodOrdering.entity.Restaurant;
import commonLLDQuestions.foodOrdering.repository.RestaurantRepo;

public class RestaurantService {

    private final RestaurantRepo restaurantRepo;


    public RestaurantService(){
        this.restaurantRepo = RestaurantRepo.getInstance();
    }

    public synchronized void addRestaurant(Restaurant restaurant) {
        restaurantRepo.addRestaurant(restaurant);
    }
}
