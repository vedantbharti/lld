package commonLLDQuestions.consistentHashing.strategy;

public interface HashingStrategy {

    //for simplicity and sortability of the keys, we have chosen generateHash to return int
    // We will use only those hash functions that return int as value or we internally do some modification to meet our goal
    public int generateHash(String key);

}
