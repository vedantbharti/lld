package commonLLDQuestions.cache.strategies;

public class LFUEvictionStrategy<K> implements EvictionStrategy<K> {
    @Override
    public void updateKeyAccessStatus(K key) {

    }

    @Override
    public K evictKey() {
        return null;
    }
}
