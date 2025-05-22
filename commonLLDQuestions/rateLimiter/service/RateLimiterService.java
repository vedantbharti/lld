package commonLLDQuestions.rateLimiter.service;

import commonLLDQuestions.rateLimiter.strategy.RateLimiterStrategy;

public class RateLimiterService {

    private RateLimiterStrategy rateLimiterStrategy;

    public RateLimiterService(RateLimiterStrategy rateLimiterStrategy) {
        this.rateLimiterStrategy = rateLimiterStrategy;
    }

    public boolean requestAllowed(String userId) {
        return rateLimiterStrategy.requestAllowed(userId);
    }

}
