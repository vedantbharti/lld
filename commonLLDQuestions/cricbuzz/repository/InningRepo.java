package commonLLDQuestions.cricbuzz.repository;

import commonLLDQuestions.cricbuzz.entity.Inning;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InningRepo {

    private Map<String, Inning> innings;

    private InningRepo(){
        this.innings = new ConcurrentHashMap<>();
    }

    private static class Initializer {
        private static final InningRepo INSTANCE = new InningRepo();
    }

    public static InningRepo getInstance() {
        return Initializer.INSTANCE;
    }
}
