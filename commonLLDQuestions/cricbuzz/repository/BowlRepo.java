package commonLLDQuestions.cricbuzz.repository;

import commonLLDQuestions.cricbuzz.entity.Bowl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BowlRepo {

    private Map<String, Bowl> bowls;

    private BowlRepo(){
        this.bowls = new ConcurrentHashMap<>();
    }

    private static class Initializer {
        private static final BowlRepo INSTANCE = new BowlRepo();
    }

    public static BowlRepo getInstance() {
        return Initializer.INSTANCE;
    }
}
