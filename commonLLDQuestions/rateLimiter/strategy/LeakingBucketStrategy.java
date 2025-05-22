package commonLLDQuestions.rateLimiter.strategy;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class LeakingBucketStrategy implements RateLimiterStrategy {

    private int capacity;
    private int outflowRate;
    private Map<String, UserBucket> buckets;
    private final ScheduledExecutorService scheduler;

    public LeakingBucketStrategy(int capacity, int outflowRate) {
        this.capacity = capacity;
        this.outflowRate = outflowRate;
        this.buckets = new ConcurrentHashMap<>();
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
        startLeaking();
    }

    private static class UserBucket {
        final Queue<String> queue = new ConcurrentLinkedQueue<>();
        final ReentrantLock lock = new ReentrantLock();
    }

    private void startLeaking() {
        long leakIntervalMillis = 1000L / outflowRate;
        scheduler.scheduleAtFixedRate(() -> {

            for(String userId: buckets.keySet()) {
                UserBucket bucket = buckets.get(userId);
                bucket.lock.lock();

                try {
                    for(int i=0;i<outflowRate;i++) {
                        if(bucket.queue.isEmpty()) {
                            break;
                        }
                        bucket.queue.poll();
                    }
                } finally {
                    bucket.lock.unlock();
                }
            }
        },leakIntervalMillis,leakIntervalMillis, TimeUnit.MILLISECONDS);

    }

    @Override
    public boolean requestAllowed(String userId) {
        UserBucket bucket = buckets.computeIfAbsent(userId, k -> new UserBucket());
        bucket.lock.lock();
        try {
            if (bucket.queue.size() < capacity) {
                bucket.queue.offer(userId);
                return true;
            } else {
                return false;
            }
        } finally {
            bucket.lock.unlock();
        }
    }

}
