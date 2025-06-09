package commonLLDQuestions.cricbuzz.service;

import commonLLDQuestions.cricbuzz.entity.Bowl;
import commonLLDQuestions.cricbuzz.repository.BowlRepo;

public class BowlService {

    private BowlRepo bowlRepo;

    public BowlService(){
        this.bowlRepo = BowlRepo.getInstance();
    }

    public void addBowl(Bowl bowl) {
        bowlRepo.addBowl(bowl);
    }
}
