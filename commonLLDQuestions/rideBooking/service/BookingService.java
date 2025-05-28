package commonLLDQuestions.rideBooking.service;

import commonLLDQuestions.rideBooking.entity.Booking;
import commonLLDQuestions.rideBooking.entity.Customer;
import commonLLDQuestions.rideBooking.entity.Driver;
import commonLLDQuestions.rideBooking.enums.BookingStatus;
import commonLLDQuestions.rideBooking.enums.VehicleType;
import commonLLDQuestions.rideBooking.exception.NoDriverAvailableException;
import commonLLDQuestions.rideBooking.repository.BookingRepo;
import commonLLDQuestions.rideBooking.strategies.PricingStrategy;

import java.util.Date;
import java.util.List;

public class BookingService {

    private final BookingRepo bookingRepo;
    private final DriverService driverService;
    private final CustomerService customerService;

    public BookingService(PricingStrategy pricingStrategy) {
        this.bookingRepo = BookingRepo.getInstance();
        this.driverService = new DriverService();
        this.customerService = new CustomerService();
    }

    public Booking bookVehicle(String cusomterId, VehicleType vehicleType, double totalCost) {

        //first get all available drivers nearby
        Customer customer = customerService.getCustomerById(cusomterId);
        List<Driver> availableDrivers = driverService.findAvailableDriversWithinRange(customer.getLocation(), vehicleType);

        if(availableDrivers.size()==0) {
            throw new NoDriverAvailableException("No driver available in your area");
        }

        Driver driver = availableDrivers.getFirst();

        //create a booking: assuming that one driver has accepted (that logic will go more into hld)
        //notify driver with pickup, drop locations and price
        //let's assume that first driver accepts the request

        Booking booking = new Booking(driver.getUserId(), cusomterId, totalCost, new Date(), customer.getLocation(), driver.getLocation());
        bookingRepo.addBooking(booking);
        System.out.println("Your ride is booked");

        return booking;
    }

    public Booking cancelBooking(String bookingId){
        return bookingRepo.updateBooking(bookingId, BookingStatus.CANCELLED);
    }


}
