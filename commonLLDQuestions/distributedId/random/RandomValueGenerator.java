package commonLLDQuestions.distributedId.random;

public class RandomValueGenerator {

    public RandomValueGenerator(){

    }

    public static long generateRandomNodeVal(long maxNoeId){
        System.out.println("maximum node id can be: " + maxNoeId);
        return Math.round(Math.random()%maxNoeId);
    }

    public static long generateRandomDataCenterVal(long maxDsId) {
        System.out.println("maximum data center id can be: " + maxDsId);
        return Math.round(Math.random()%maxDsId);
    }
}
