package commonLLDQuestions.rateLimiter.strategy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SldingWindowLogStrategy implements RateLimiterStrategy{

    private int maxRequests;
    private int windowSizeInSec;
    private Map<String, Deque<Long>> userRequests;

    public SldingWindowLogStrategy(int maxRequests, int windowSizeInSec) {
        this.maxRequests = maxRequests;
        this.windowSizeInSec = windowSizeInSec;
        this.userRequests = new ConcurrentHashMap<>();
    }

    @Override
    public boolean requestAllowed(String userId) {

        long now = System.currentTimeMillis();
        Deque<Long> log = userRequests.computeIfAbsent(userId, key -> new ArrayDeque<>());

        synchronized (log) {
            while (!log.isEmpty() && now - log.peekFirst()>=windowSizeInSec*1000) {
                log.pollFirst();
            }

            if (log.size()<maxRequests) {
                log.offerLast(now);
                return true;
            } else {
                return false;
            }
        }
    }
}
