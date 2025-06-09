package commonLLDQuestions.cricbuzz.service;

import commonLLDQuestions.cricbuzz.entity.ScoreCard;
import commonLLDQuestions.cricbuzz.enums.WicketType;

public interface ScoreCardService {

    public ScoreCard createScoreCardIfNotPresent(String inningId, String playerId);
    public void updateScoreCard(String scoreCardId, int run, boolean isAWicket, WicketType wicketType);
}
