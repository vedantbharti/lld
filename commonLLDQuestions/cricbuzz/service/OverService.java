package commonLLDQuestions.cricbuzz.service;

import commonLLDQuestions.cricbuzz.repository.OverRepo;

public class OverService {

    private OverRepo overRepo;

    public OverService() {
        this.overRepo = OverRepo.getInstance();
    }
}
