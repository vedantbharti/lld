package commonLLDQuestions.cache;

import commonLLDQuestions.cache.enums.StorageTypes;
import commonLLDQuestions.cache.exception.KeyDoesNotExistException;
import commonLLDQuestions.cache.service.CacheService;
import commonLLDQuestions.cache.strategies.EvictionStrategy;
import commonLLDQuestions.cache.strategies.LFUEvictionStrategy;
import commonLLDQuestions.cache.strategies.LRUEvictionStrategy;

public class Cache {

    public static void main(String[] args) {

        EvictionStrategy<Integer> lruEvictionStrategy = new LRUEvictionStrategy<>();
        CacheService<Integer,Integer> hashmapBasedLRUCache = new CacheService<>(StorageTypes.HASHMAP, 2, lruEvictionStrategy);


        hashmapBasedLRUCache.put(1,1);
        hashmapBasedLRUCache.put(2,2);
        hashmapBasedLRUCache.put(3,3);

        try {
            int val1 = hashmapBasedLRUCache.get(1);
            int val2 = hashmapBasedLRUCache.get(2);
            int val3 = hashmapBasedLRUCache.get(3);

            System.out.println("the value is: " + val1);
            System.out.println("the value is: " + val2);
            System.out.println("the value is: " + val3);
        } catch (KeyDoesNotExistException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



        EvictionStrategy<Integer> lfuEvictionStrategy = new LFUEvictionStrategy<>();
        CacheService<Integer,Integer> hashmapBasedLFUCache = new CacheService<>(StorageTypes.HASHMAP, 2, lfuEvictionStrategy);


        hashmapBasedLFUCache.put(1,1);
        hashmapBasedLFUCache.put(2,2);
        hashmapBasedLFUCache.get(1);
        hashmapBasedLFUCache.put(3,3);

        try {
            int val1 = hashmapBasedLFUCache.get(1);
            int val2 = hashmapBasedLFUCache.get(2);
            int val3 = hashmapBasedLFUCache.get(3);

            System.out.println("the value is: " + val1);
            System.out.println("the value is: " + val2);
            System.out.println("the value is: " + val3);
        } catch (KeyDoesNotExistException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }





    }
}
