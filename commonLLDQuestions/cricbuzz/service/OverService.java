package commonLLDQuestions.cricbuzz.service;

import commonLLDQuestions.cricbuzz.entity.Over;
import commonLLDQuestions.cricbuzz.repository.OverRepo;

public class OverService {

    private OverRepo overRepo;

    public OverService() {
        this.overRepo = OverRepo.getInstance();
    }

    public void addOver(Over over) {
        overRepo.addOver(over);
    }
}
