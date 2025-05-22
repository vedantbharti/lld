package commonLLDQuestions.consistentHashing.service;

import commonLLDQuestions.consistentHashing.strategy.HashingStrategy;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConsistentHashService<T> {

    private final HashingStrategy hashingStrategy;
    private final int virtualNodes;
    private final ConcurrentSkipListMap<Integer,T> ring;
    private final Set<T> nodes;

    public ConsistentHashService(HashingStrategy hashingStrategy, int virtualNodes) {
        this.hashingStrategy = hashingStrategy;
        this.virtualNodes = virtualNodes;
        /*
        Used ConcurrentSkipListMap because we need the nodes to be sorted
        (the requirement is that we must know which
        node the data is mapped to. If we have simple Hashmap and add or remove node, the whole arrangement of keys change
        In that case, we don't know, which data was mapped to which node(since the logic is that map the data with the
        node just next to it.)
        ConcurrentSkipListMap is just a better alternative to TreeMap to ensure thread-safety
         */
        this.ring = new ConcurrentSkipListMap<>();
        this.nodes = new HashSet<>();
    }

    public synchronized void addNode(T node) {

        nodes.add(node);
        for(int i=0;i<virtualNodes;i++) {
            int hashKey = hashingStrategy.generateHash(node.toString() + "-VN-" + i);
            ring.put(hashKey,node);
        }
    }

    public synchronized void removeNode(T node) {
        nodes.remove(node);
        for(int i=0;i<virtualNodes;i++) {
            int hashKey = hashingStrategy.generateHash(node.toString() + "-VN-" + i);
            ring.remove(hashKey);
        }
    }

    public T getNode(T key) {
        if(ring.isEmpty()) return null;

        int hashKey = hashingStrategy.generateHash(key.toString());
        Map.Entry<Integer,T> entry = ring.ceilingEntry(hashKey);
        if(entry==null) {
            return ring.firstEntry().getValue();
        } else {
            return entry.getValue();
        }
    }

    public Set<T> getAllNodes() {
        return Collections.unmodifiableSet(nodes);
    }
}
