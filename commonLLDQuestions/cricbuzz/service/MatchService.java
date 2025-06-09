package commonLLDQuestions.cricbuzz.service;

import commonLLDQuestions.cricbuzz.entity.Match;
import commonLLDQuestions.cricbuzz.repository.MatchRepo;

public class MatchService {

    private MatchRepo matchRepo;

    public MatchService() {
        this.matchRepo = MatchRepo.getInstance();
    }

    public void addMatch(Match match) {
        matchRepo.addMatch(match);
    }
}
