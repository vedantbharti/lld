package commonLLDQuestions.rideBooking.repository;

import commonLLDQuestions.rideBooking.entity.Booking;
import commonLLDQuestions.rideBooking.enums.BookingStatus;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BookingRepo {


    private Map<String, Booking> bookings;

    private BookingRepo() {
        this.bookings = new ConcurrentHashMap<>();
    }

    private static class Initializer {
        private static final BookingRepo INSTANCE = new BookingRepo();
    }

    public static BookingRepo getInstance(){
        return Initializer.INSTANCE;
    }

    public void addBooking(Booking booking) {
        bookings.put(booking.getBookingId(),booking);
    }

    public Booking updateBooking(String bookingId, BookingStatus bookingStatus) {
        bookings.get(bookingId).setBookingStatus(bookingStatus);
        return bookings.get(bookingId);
    }
}
