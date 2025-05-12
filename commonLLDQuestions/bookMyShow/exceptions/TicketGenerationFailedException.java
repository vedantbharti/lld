package commonLLDQuestions.bookMyShow.exceptions;

public class TicketGenerationFailedException extends RuntimeException{

    public TicketGenerationFailedException(String message) {
        super(message);
    }
}
