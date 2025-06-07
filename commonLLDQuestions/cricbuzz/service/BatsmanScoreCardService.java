package commonLLDQuestions.cricbuzz.service;

import commonLLDQuestions.cricbuzz.repository.ScoreCardRepo;

public class BatsmanScoreCardService implements ScoreCardService{

    private ScoreCardRepo scoreCardRepo;

    public BatsmanScoreCardService(){
        this.scoreCardRepo = ScoreCardRepo.getInstance();
    }
}
