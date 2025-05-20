package commonLLDQuestions.distributedId.service;

import commonLLDQuestions.distributedId.strategy.IdGenerationStrategy;

public class IdGeneratorService {

    private IdGenerationStrategy idGenerationStrategy;

    public IdGeneratorService(IdGenerationStrategy idGenerationStrategy) {
        this.idGenerationStrategy = idGenerationStrategy;
    }

    public synchronized long generateUniqueId(){
        return idGenerationStrategy.generateId();
    }
}
