package commonLLDQuestions.cache.strategies;

public interface EvictionStrategy<K> {

    void updateKeyAccessStatus(K key);

    K evict();
}
