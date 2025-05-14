package commonLLDQuestions.carRental.exception;

public class VehicleAlreadyAddedException extends RuntimeException{

    public VehicleAlreadyAddedException(String message) {
        super(message);
    }
}
