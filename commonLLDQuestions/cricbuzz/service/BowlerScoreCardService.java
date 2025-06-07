package commonLLDQuestions.cricbuzz.service;

import commonLLDQuestions.cricbuzz.repository.ScoreCardRepo;

public class BowlerScoreCardService implements ScoreCardService{

    private ScoreCardRepo scoreCardRepo;

    public BowlerScoreCardService() {
        this.scoreCardRepo = ScoreCardRepo.getInstance();
    }
}
