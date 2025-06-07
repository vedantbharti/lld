package commonLLDQuestions.cricbuzz.service;

import commonLLDQuestions.cricbuzz.repository.BowlRepo;

public class BowlService {

    private BowlRepo bowlRepo;

    public BowlService(){
        this.bowlRepo = BowlRepo.getInstance();
    }
}
