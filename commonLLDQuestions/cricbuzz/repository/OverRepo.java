package commonLLDQuestions.cricbuzz.repository;

import commonLLDQuestions.cricbuzz.entity.Over;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OverRepo {

    private Map<String, Over> overs;

    private OverRepo(){
        this.overs = new ConcurrentHashMap<>();
    }

    private static class Initializer {
        private static final OverRepo INSTANCE = new OverRepo();
    }

    public static OverRepo getInstance() {
        return Initializer.INSTANCE;
    }

    public void addOver(Over over) {
        overs.put(over.getOverId(),over);
    }
}
