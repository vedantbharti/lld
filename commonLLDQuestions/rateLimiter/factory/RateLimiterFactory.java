package commonLLDQuestions.rateLimiter.factory;

import commonLLDQuestions.rateLimiter.enums.RateLimiterAlgo;
import commonLLDQuestions.rateLimiter.exception.AlgorithmNotFoundException;
import commonLLDQuestions.rateLimiter.strategy.*;

public class RateLimiterFactory {

    public RateLimiterStrategy create(RateLimiterAlgo rateLimiterAlgo, int limit, int rateOrWindow) {

//        TOKEN_BUCKET, LEAKING_BUCKET, FIXED_WINDOW_COUNTER, SLIDING_WINDOW_LOG
        return switch (rateLimiterAlgo) {
            case TOKEN_BUCKET -> new TokenBucketStrategy(limit,rateOrWindow);
            case LEAKING_BUCKET -> new LeakingBucketStrategy(limit,rateOrWindow);
            case FIXED_WINDOW_COUNTER -> new FixedWindowCounterStrategy(limit,rateOrWindow);
            case SLIDING_WINDOW_LOG -> new SldingWindowLogStrategy(limit,rateOrWindow);
            default -> throw new AlgorithmNotFoundException("unknown algortihm: " + rateLimiterAlgo);
        };
    }
}
