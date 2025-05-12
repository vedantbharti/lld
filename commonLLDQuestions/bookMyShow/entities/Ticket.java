package commonLLDQuestions.bookMyShow.entities;

import commonLLDQuestions.bookMyShow.models.Seat;

import java.util.List;

public class Ticket {

    private int ticketId;
    private Show show;
    private List<Seat> bookedSeats;
    private double paymentAmount;

    public Ticket(int ticketId, Show show, List<Seat> bookedSeats, double paymentAmount) {
        this.ticketId = ticketId;
        this.show = show;
        this.bookedSeats = bookedSeats;
        this.paymentAmount = paymentAmount;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<Seat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public double getPayment() {
        return paymentAmount;
    }

    public void setPayment(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}
