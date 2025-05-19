package commonLLDQuestions.cache.service;

import commonLLDQuestions.cache.enums.EvictionStrategyTypes;
import commonLLDQuestions.cache.enums.StorageTypes;
import commonLLDQuestions.cache.factory.StorageFactory;
import commonLLDQuestions.cache.repository.Storage;
import commonLLDQuestions.cache.strategies.EvictionStrategy;

public class CacheService<K,V> {

    private final StorageFactory<K,V> storageFactory;

    private Storage<K,V> hashBasedStorage;

    private EvictionStrategy<K> evictionStrategy;

    private int capacity;

    public CacheService(StorageTypes storageTypes, int capacity, EvictionStrategy<K> evictionStrategy) {
        storageFactory = new StorageFactory<>();
        hashBasedStorage = storageFactory.getStorageType(storageTypes, capacity);
        this.evictionStrategy = evictionStrategy;
        this.capacity = capacity;
    }


    public V get(K key) {
        V val = hashBasedStorage.get(key);
        evictionStrategy.updateKeyAccessStatus(key);
        return val;
    }

    public void put(K key, V val) {
        if(hashBasedStorage.getSize()<capacity) {
            hashBasedStorage.put(key,val);
            evictionStrategy.updateKeyAccessStatus(key);
        } else {
            K evictedKey = evictionStrategy.evict();
            System.out.println("the evicted key is: " + evictedKey);
            hashBasedStorage.remove(evictedKey);
            evictionStrategy.updateKeyAccessStatus(key);
            hashBasedStorage.put(key,val);
        }
    }

}
