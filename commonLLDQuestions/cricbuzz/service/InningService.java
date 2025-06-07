package commonLLDQuestions.cricbuzz.service;

import commonLLDQuestions.cricbuzz.repository.InningRepo;

public class InningService {

    private InningRepo inningRepo;

    public InningService() {
        this.inningRepo = InningRepo.getInstance();
    }
}
