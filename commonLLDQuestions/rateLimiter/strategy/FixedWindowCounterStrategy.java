package commonLLDQuestions.rateLimiter.strategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FixedWindowCounterStrategy implements RateLimiterStrategy{


    private int maxRequests;
    private int windowSizeInSec;
    private Map<String, UserRequest> userRequests;


    public FixedWindowCounterStrategy(int maxRequests, int windowSizeInSec) {
        this.maxRequests = maxRequests;
        this.windowSizeInSec = windowSizeInSec;
        this.userRequests = new ConcurrentHashMap<>();
    }

    private static class UserRequest {
        int requestCount;
        long lastWindowStartTimestamp;
    }

    @Override
    public boolean requestAllowed(String userId) {
        long now = System.currentTimeMillis();
        UserRequest userRequest = userRequests.computeIfAbsent(userId, key -> {
            UserRequest request = new UserRequest();
            request.requestCount = 0;
            request.lastWindowStartTimestamp = now;
            return request;
        });

        synchronized (userRequest) {
            if(now - userRequest.lastWindowStartTimestamp > windowSizeInSec*1000) {
                userRequest.requestCount = 0;
                userRequest.lastWindowStartTimestamp = now;
            }

            if(userRequest.requestCount<maxRequests) {
                userRequest.requestCount++;
                return true;
            } {
                return false;
            }
        }

    }
}
