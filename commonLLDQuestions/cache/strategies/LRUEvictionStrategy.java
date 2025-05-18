package commonLLDQuestions.cache.strategies;

import commonLLDQuestions.cache.dataStructures.DoublyLinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionStrategy<K> implements EvictionStrategy<K> {
    DoublyLinkedList<K> doublyLinkedList;
    Map<K,DoublyLinkedList<K>> map;
    DoublyLinkedList<K> lastNode;

    public LRUEvictionStrategy(){
        doublyLinkedList = new DoublyLinkedList<>();
        map = new HashMap<>();
        lastNode = doublyLinkedList;
    }

    @Override
    public void updateKeyAccessStatus(K key) {
        if(!map.containsKey(key)) {
            DoublyLinkedList<K> newNode = new DoublyLinkedList<>(key);
            lastNode.setNext(newNode);
            newNode.setPrev(lastNode);
            lastNode = newNode;
            map.put(key,lastNode);
        } else {
            DoublyLinkedList<K> node = map.get(key);
            DoublyLinkedList<K> prevNode = node.getPrev();
            DoublyLinkedList<K> nextNode = node.getNext();
            if(prevNode!=null) {
                prevNode.setNext(nextNode);
            } else {
                doublyLinkedList = nextNode;
            }
            nextNode.setPrev(prevNode);
            lastNode.setNext(node);
            node.setPrev(lastNode);
            lastNode = node;
        }
    }

    @Override
    public K evictKey() {
        DoublyLinkedList<K> firstNode = doublyLinkedList;
        doublyLinkedList = doublyLinkedList.getNext();
        doublyLinkedList.setPrev(null);
        K val = firstNode.getValue();
        map.remove(val);
        return val;

    }
}
