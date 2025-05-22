package commonLLDQuestions.consistentHashing;

import commonLLDQuestions.consistentHashing.service.ConsistentHashService;
import commonLLDQuestions.consistentHashing.strategy.HashingStrategy;
import commonLLDQuestions.consistentHashing.strategy.MD5HashingStrategy;

public class ConsistentHashing {

    public static void main(String[] args) {

        HashingStrategy md5HashingStrategy = new MD5HashingStrategy();
        ConsistentHashService<String> consistentHashService = new ConsistentHashService<>(md5HashingStrategy,20);

        consistentHashService.addNode("Server-A");
        consistentHashService.addNode("Server-B");
        consistentHashService.addNode("Server-C");

        for (int i = 0; i < 10; i++) {
            String key = "user-" + i;
            System.out.println(key + " => " + consistentHashService.getNode(key));
        }

        System.out.println("Removing Server-B...");
        consistentHashService.removeNode("Server-B");

        for (int i = 0; i < 10; i++) {
            String key = "user-" + i;
            System.out.println(key + " => " + consistentHashService.getNode(key));
        }

    }
}
