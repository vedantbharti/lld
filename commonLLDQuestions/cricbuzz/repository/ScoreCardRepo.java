package commonLLDQuestions.cricbuzz.repository;

import commonLLDQuestions.cricbuzz.entity.ScoreCard;

import java.util.List;
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

    public void addScoreCard(ScoreCard scoreCard) {
        scoreCards.put(scoreCard.getScoreCardId(),scoreCard);
    }

    public ScoreCard getScoreCardById(String scoreCardId) {
        return scoreCards.get(scoreCardId);
    }

    public ScoreCard getScoreCardForInningAndPlayer(String inningId, String playerId) {
        List<ScoreCard> scoreCardList = scoreCards.values().stream().toList();
        for(ScoreCard scoreCard : scoreCardList) {
            if(scoreCard.getInningId().equals(inningId) && scoreCard.getPlayerId().equals(playerId)) {
                return scoreCard;
            }
        }

        return null;
    }
}
