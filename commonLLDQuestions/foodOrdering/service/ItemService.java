package commonLLDQuestions.foodOrdering.service;

import commonLLDQuestions.foodOrdering.entity.Item;
import commonLLDQuestions.foodOrdering.repository.ItemRepo;

public class ItemService {

    private final ItemRepo itemRepo;

    public ItemService() {
        this.itemRepo = ItemRepo.getInstance();
    }

    public synchronized void addOrUpdateItem(Item item) {
        itemRepo.addOrUpdateItem(item);
    }

    public Item getItemById(String itemId) {
        return itemRepo.getItemById(itemId);
    }
}
