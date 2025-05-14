package commonLLDQuestions.carRental.service;

import commonLLDQuestions.carRental.entities.Booking;
import commonLLDQuestions.carRental.entities.Payment;
import commonLLDQuestions.carRental.entities.Vehicle;
import commonLLDQuestions.carRental.enums.BookingStatus;
import commonLLDQuestions.carRental.exception.PaymentFailedException;
import commonLLDQuestions.carRental.exception.VehicleBookedException;
import commonLLDQuestions.carRental.repository.BookingRepository;
import commonLLDQuestions.carRental.util.Handler;
import commonLLDQuestions.carRental.util.PaymentHandler;
import commonLLDQuestions.carRental.util.VehicleAvailabilityHandler;

import java.util.Date;

public class BookingService {

    private BookingRepository bookingRepository;

    public BookingService(){
        this.bookingRepository = BookingRepository.getInstance();
    }

    public void addBooking(Booking booking) {
        bookingRepository.addBooking(booking);
    }

    public Booking bookVehicle(int bookingId, int userId, Vehicle vehicle, Date starTime, Date endTime) {

        Booking booking = new Booking(bookingId,userId,vehicle.getVehicleNo(),starTime, endTime);
        bookingRepository.addBooking(booking);
        Handler chain = new VehicleAvailabilityHandler();
        chain.setNext(new PaymentHandler());

        boolean response = false;

        try {
            response = chain.handleBooking(booking);
        } catch (VehicleBookedException e){
            System.out.println(e.getMessage());
            booking.setBookingStatus(BookingStatus.FAILED);
        } catch (PaymentFailedException e) {
            System.out.println(e.getMessage());
            booking.setBookingStatus(BookingStatus.FAILED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            booking.setBookingStatus(BookingStatus.FAILED);
        }

        if(response){
            booking.setBookingStatus(BookingStatus.COMPLETED);
        } else {
            booking.setBookingStatus(BookingStatus.FAILED);
        }

        return booking;
    }

    public Booking cancelBooking(int bookingId){
        Booking booking = bookingRepository.getBooking(bookingId);
        Handler chain  = new VehicleAvailabilityHandler();
        chain.setNext(new PaymentHandler());
        chain.handleCancellation(booking);
        booking.setBookingStatus(BookingStatus.CANCELLED);
        return booking;
    }
}
