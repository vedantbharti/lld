package commonLLDQuestions.rideBooking.exception;

public class NoDriverAvailableException extends RuntimeException{

    public NoDriverAvailableException(String message) {
        super(message);
    }
}
