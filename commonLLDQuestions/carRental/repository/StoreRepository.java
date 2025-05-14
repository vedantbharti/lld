package commonLLDQuestions.carRental.repository;

import commonLLDQuestions.carRental.entities.Store;
import commonLLDQuestions.carRental.entities.Vehicle;
import commonLLDQuestions.carRental.models.Location;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StoreRepository {

    Map<Integer, Store> stores;

    private StoreRepository() {
        stores = new HashMap<>();
    }

    private static class Initializer {
        private static final StoreRepository INSTANCE = new StoreRepository();
    }

    public static StoreRepository getInstance() {
        return Initializer.INSTANCE;
    }

    public void addStore(Store store) {
        stores.put(store.getStoreId(),store);
    }

    public Store getStoreDetails(int storeId){
        return stores.get(storeId);
    }

    public List<Store> getStoresForLocation(Location location) {
        System.out.println("size of the list is: " + stores.size());
        return stores.values().stream().filter(store -> store.getLocation().equals(location)).collect(Collectors.toList());
    }
}
