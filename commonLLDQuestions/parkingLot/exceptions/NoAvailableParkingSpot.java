package commonLLDQuestions.parkingLot.exceptions;

public class NoAvailableParkingSpot extends RuntimeException{

    public NoAvailableParkingSpot(String message) {
        super(message);
    }
}
