package commonLLDQuestions.carRental.util;

import commonLLDQuestions.carRental.entities.Booking;

public abstract class Handler {

    protected Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public abstract boolean handleBooking(Booking booking);

    public abstract void handleCancellation(Booking booking);
}
