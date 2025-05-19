package commonLLDQuestions.cache.strategies;

import commonLLDQuestions.cache.dataStructures.DoublyLinkedList;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class LFUEvictionStrategy<K> implements EvictionStrategy<K> {

    Map<K,Integer> map;
    Map<Integer, LinkedHashSet<K>> frequencies;
    int minFrequency;

    public LFUEvictionStrategy(){
        System.out.println("We are using LFU eviction strategy");
        map = new HashMap<>();
        frequencies = new HashMap<>();
        minFrequency = 0;
    }


    @Override
    public void updateKeyAccessStatus(K key) {
        if(!map.containsKey(key)) {
            minFrequency = 1;
            map.put(key,1);
            LinkedHashSet<K> keysWithGivenFrequency = frequencies.get(minFrequency);
            if(keysWithGivenFrequency==null){
                keysWithGivenFrequency = new LinkedHashSet<>();
            }
            keysWithGivenFrequency.add(key);
            frequencies.put(minFrequency,keysWithGivenFrequency);

        } else {
            int frequency = map.get(key);
            Set<K> keysWithGivenFrequency = frequencies.get(frequency);
            keysWithGivenFrequency.remove(key);
            if(keysWithGivenFrequency.isEmpty()){
                map.remove(key);
                if(minFrequency==frequency) {
                    minFrequency++;
                }
            }
            frequency++;
            map.put(key,frequency);
            frequencies.putIfAbsent(frequency,new LinkedHashSet<>());
            frequencies.get(frequency).add(key);
        }

    }

    @Override
    public K evict() {
        Set<K> keysWithGivenFrequency = frequencies.get(minFrequency);
        K keyToDelete = keysWithGivenFrequency.iterator().next();
        map.remove(keyToDelete);
        keysWithGivenFrequency.remove(keyToDelete);
        if(keysWithGivenFrequency.isEmpty()) {
            frequencies.remove(minFrequency);
        }

        return keyToDelete;
    }
}
