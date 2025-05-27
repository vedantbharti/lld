package commonLLDQuestions.rideBooking.service;

import commonLLDQuestions.rideBooking.repository.BookingRepo;

public class BookingService {

    private final BookingRepo bookingRepo;

    public BookingService() {
        this.bookingRepo = BookingRepo.getInstance();
    }


}
