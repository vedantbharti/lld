package commonLLDQuestions.cricbuzz.service;

import commonLLDQuestions.cricbuzz.enums.BowlType;
import commonLLDQuestions.cricbuzz.enums.WicketType;

public class ScoreUpdaterService {

    private final ScoreCardService bowlerScoreCardService;
    private final ScoreCardService batsmanScoreCardService;
    private final InningService inningService;

    public ScoreUpdaterService() {
        this.bowlerScoreCardService = new BowlerScoreCardService();
        this.batsmanScoreCardService = new BatsmanScoreCardService();
        this.inningService = new InningService();
    }

    public void updateScore(String inningId, String bowlerScoreCardId, String batsmanScoreCardId, BowlType bowlType, int run, boolean isAWicket, WicketType wicketType) {
        if(bowlType.equals(BowlType.NORMAL)) {
            bowlerScoreCardService.updateScoreCard(bowlerScoreCardId,run,isAWicket,wicketType);
            batsmanScoreCardService.updateScoreCard(batsmanScoreCardId,run,isAWicket,wicketType);
            inningService.updateTotalScore(inningId,run);
            if(isAWicket) {
                inningService.updateTotalWickets(inningId);
            }
        } else {
            bowlerScoreCardService.updateScoreCard(bowlerScoreCardId,run,isAWicket,wicketType);
            inningService.updateTotalScore(inningId,run);
        }
    }
}
