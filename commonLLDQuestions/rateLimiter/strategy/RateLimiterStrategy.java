package commonLLDQuestions.rateLimiter.strategy;

public interface RateLimiterStrategy {

    public boolean requestAllowed(String requestId);
}
