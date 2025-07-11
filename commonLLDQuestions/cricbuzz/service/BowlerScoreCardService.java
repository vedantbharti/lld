package commonLLDQuestions.cricbuzz.service;

import commonLLDQuestions.cricbuzz.entity.ScoreCard;
import commonLLDQuestions.cricbuzz.enums.WicketType;
import commonLLDQuestions.cricbuzz.repository.ScoreCardRepo;

public class BowlerScoreCardService implements ScoreCardService{

    private ScoreCardRepo scoreCardRepo;

    public BowlerScoreCardService() {
        this.scoreCardRepo = ScoreCardRepo.getInstance();
    }

    @Override
    public ScoreCard createScoreCardIfNotPresent(String inningId, String playerId) {
        ScoreCard scoreCard = scoreCardRepo.getScoreCardForInningAndPlayer(inningId,playerId);
        if(scoreCard==null) {
            scoreCard = new ScoreCard(inningId,playerId);
            scoreCardRepo.addScoreCard(scoreCard);
        }

        return scoreCard;
    }

    public void updateScoreCard(String scoreCardId, int run, boolean isAWicket, WicketType wicketType) {
        ScoreCard scoreCard = scoreCardRepo.getScoreCardById(scoreCardId);
        int totalRunsGiven = scoreCard.getTotalRunsGiven();
        totalRunsGiven += run;
        scoreCard.setTotalRunsGiven(totalRunsGiven);

        if(isAWicket) {
            int totalWickets = scoreCard.getTotalWickets();
            totalWickets += 1;
            scoreCard.setTotalWickets(totalWickets);
            scoreCard.getWicketTypes().add(wicketType);
        }
    }
}
