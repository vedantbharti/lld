package commonLLDQuestions.carRental.repository;

import commonLLDQuestions.carRental.entities.Booking;

import java.util.HashMap;
import java.util.Map;

public class BookingRepository {

    Map<Integer, Booking> bookings;

    private BookingRepository(){
        bookings = new HashMap<>();
    }

    private static class Initialize {
        private static final BookingRepository INSTANCE = new BookingRepository();
    }

    public static BookingRepository getInstance() {
        return Initialize.INSTANCE;
    }

    public void addBooking(Booking booking) {
        bookings.put(booking.getBookingId(),booking);
    }

    public Booking getBooking(int bookingId){
        return bookings.get(bookingId);
    }
}
