package commonLLDQuestions.cache.repository;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<K,V> implements Storage<K,V>{

    Map<K,V> map;

    public HashMapBasedStorage() {
        map = new HashMap<>();
    }
    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void put(K key, V value) {

    }

    @Override
    public void remove(K key) {

    }
}
