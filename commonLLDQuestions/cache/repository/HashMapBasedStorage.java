package commonLLDQuestions.cache.repository;

import commonLLDQuestions.cache.exception.KeyDoesNotExistException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<K,V> implements Storage<K,V>{

    Map<K,V> map;
    int capacity;

    public HashMapBasedStorage(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
    }


    @Override
    public V get(K key) {
        if(map.containsKey(key)){
            return map.get(key);
        } else {
            throw new KeyDoesNotExistException("the key " + key + " does not exist");
        }

    }

    @Override
    public void put(K key, V value) {
        map.put(key,value);
    }

    @Override
    public void remove(K key) {
        map.remove(key);
    }

    public int getSize(){
        return map.size();
    }
}
