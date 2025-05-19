package commonLLDQuestions.cache.strategies;

import commonLLDQuestions.cache.dataStructures.DoublyLinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionStrategy<K> implements EvictionStrategy<K> {
    Map<K,DoublyLinkedList<K>> map;
    DoublyLinkedList<K> firstNode;
    DoublyLinkedList<K> lastNode;

    public LRUEvictionStrategy(){

        System.out.println("We are using LRU eviction strategy");
        firstNode = new DoublyLinkedList<>();
        lastNode = new DoublyLinkedList<>();
        firstNode.setNext(lastNode);
        lastNode.setPrev(firstNode);
        map = new HashMap<>();
    }

    @Override
    public void updateKeyAccessStatus(K key) {
        if(!map.containsKey(key)) {
            DoublyLinkedList<K> newNode = new DoublyLinkedList<>(key);
            DoublyLinkedList<K> prevNode = lastNode.getPrev();
            prevNode.setNext(newNode);
            newNode.setPrev(prevNode);
            newNode.setNext(lastNode);
            lastNode.setPrev(newNode);
            map.put(key,lastNode);
        } else {
            DoublyLinkedList<K> node = map.get(key);
            DoublyLinkedList<K> prevNode = node.getPrev();
            DoublyLinkedList<K> nextNode = node.getNext();
            node.setNext(null);
            node.setPrev(null);
            prevNode.setNext(nextNode);
            nextNode.setPrev(prevNode);
            prevNode = lastNode.getPrev();
            prevNode.setNext(node);
            node.setPrev(prevNode);
            node.setNext(lastNode);
            lastNode.setPrev(node);
        }
    }

    @Override
    public K evict() {
        DoublyLinkedList<K> evictableNode = firstNode.getNext();
        firstNode.setNext(evictableNode.getNext());
        evictableNode.getNext().setPrev(firstNode);
        evictableNode.setNext(null);
        K val = evictableNode.getValue();
        map.remove(val);
        return val;

    }
}
