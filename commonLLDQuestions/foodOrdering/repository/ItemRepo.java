package commonLLDQuestions.foodOrdering.repository;

import commonLLDQuestions.foodOrdering.entity.Item;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ItemRepo {

    private Map<String, Item> items;

    private ItemRepo(){
        this.items = new ConcurrentHashMap<>();
    }

    private static class Initializer {
        private static final ItemRepo INSTANCE = new ItemRepo();
    }

    public static ItemRepo getInstance() {
        return Initializer.INSTANCE;
    }
}
