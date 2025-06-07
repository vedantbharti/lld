package commonLLDQuestions.cricbuzz.repository;

import commonLLDQuestions.cricbuzz.entity.ScoreCard;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ScoreCardRepo {

    private Map<String, ScoreCard> scoreCards;

    private ScoreCardRepo(){
        this.scoreCards = new ConcurrentHashMap<>();
    }

    private static class Initializer {
        private static final ScoreCardRepo INSTANCE = new ScoreCardRepo();
    }

    public static ScoreCardRepo getInstance() {
        return Initializer.INSTANCE;
    }
}
