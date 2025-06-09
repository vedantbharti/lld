package commonLLDQuestions.cricbuzz.service;

import commonLLDQuestions.cricbuzz.entity.Inning;
import commonLLDQuestions.cricbuzz.repository.InningRepo;

public class InningService {

    private InningRepo inningRepo;

    public InningService() {
        this.inningRepo = InningRepo.getInstance();
    }

    public void addInning(Inning inning) {
        inningRepo.addInning(inning);
    }

    public void updateTotalScore(String inningId, int run) {
        Inning inning = inningRepo.getInningById(inningId);
        int totalScore = inning.getTotalScore();
        totalScore+= run;
        inning.setTotalScore(totalScore);
    }

    public void updateTotalWickets(String inningId) {
        Inning inning = inningRepo.getInningById(inningId);
        int totalWicket = inning.getTotalWickets();
        totalWicket++;
        inning.setTotalWickets(totalWicket);
    }
}
