package commonLLDQuestions.rateLimiter;

import commonLLDQuestions.rateLimiter.enums.RateLimiterAlgo;
import commonLLDQuestions.rateLimiter.exception.AlgorithmNotFoundException;
import commonLLDQuestions.rateLimiter.factory.RateLimiterFactory;
import commonLLDQuestions.rateLimiter.service.RateLimiterService;
import commonLLDQuestions.rateLimiter.strategy.LeakingBucketStrategy;
import commonLLDQuestions.rateLimiter.strategy.RateLimiterStrategy;

public class RateLimiter {

    public static void main(String[] args) {

        RateLimiterFactory rateLimiterFactory = new RateLimiterFactory();
        //change the enum to check the functionality of each algorithm

        try {
            RateLimiterStrategy tokenBucketStrategy = rateLimiterFactory.create(RateLimiterAlgo.TOKEN_BUCKET,10,1);
            RateLimiterService rateLimiterService = new RateLimiterService(tokenBucketStrategy);

            String user1 = "User1";
            for (int i = 0; i < 1000; i++) {
                boolean allowed = rateLimiterService.requestAllowed(user1);
                System.out.println("Request " + (i + 1) + ": " + (allowed ? "Allowed" : "Blocked"));
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted!");
                }
            }
        } catch (AlgorithmNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //for leaky bucket algorithm , we need to stop the scheduler too. Not implemented here due to use of strategy pattern
        //in real life scenario, only one of these algorithm will be used in practice based on requirement


    }
}
