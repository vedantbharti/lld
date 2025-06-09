package commonLLDQuestions.cricbuzz.repository;

import commonLLDQuestions.cricbuzz.entity.Match;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MatchRepo {

    private Map<String, Match> matches;

    private MatchRepo(){
        this.matches = new ConcurrentHashMap<>();
    }

    private static class Initializer {
        private static final MatchRepo INSTANCE = new MatchRepo();
    }

    public static MatchRepo getInstance() {
        return Initializer.INSTANCE;
    }

    public void addMatch(Match match) {
        matches.put(match.getMatchId(),match);
    }
}
