package commonLLDQuestions.rateLimiter.strategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenBucketStrategy implements RateLimiterStrategy {

    private int capacity;
    private int refillRatePerSecond;
    private Map<String,Bucket> buckets;

    public TokenBucketStrategy(int capacity, int refillRatePerSecond) {
        this.capacity = capacity;
        this.refillRatePerSecond = refillRatePerSecond;
        this.buckets = new ConcurrentHashMap<>();
    }

    private static class Bucket {
        int tokens;
        long lastRefillTimestamp;
    }

    @Override
    public synchronized boolean requestAllowed(String userId) {
        long now = System.currentTimeMillis();
        Bucket bucket;
        if(!buckets.containsKey(userId)) {
            Bucket b = new Bucket();
            b.tokens = capacity;
            b.lastRefillTimestamp = now;
            buckets.put(userId,b);
            bucket = b;
        } else {
            bucket = buckets.get(userId);
        }

        long delta = now - bucket.lastRefillTimestamp;
        if(delta >= 1000) {
            bucket.tokens = Math.max(capacity,bucket.tokens + refillRatePerSecond);
            bucket.lastRefillTimestamp = now;
        }

        if(bucket.tokens>0) {
            bucket.tokens--;
            return true;
        }

        return false;
    }
}
