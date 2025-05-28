package commonLLDQuestions.rideBooking;

import commonLLDQuestions.rideBooking.entity.*;
import commonLLDQuestions.rideBooking.enums.BookingStatus;
import commonLLDQuestions.rideBooking.enums.PaymentStatus;
import commonLLDQuestions.rideBooking.enums.UserType;
import commonLLDQuestions.rideBooking.enums.VehicleType;
import commonLLDQuestions.rideBooking.exception.NoDriverAvailableException;
import commonLLDQuestions.rideBooking.model.Location;
import commonLLDQuestions.rideBooking.service.*;
import commonLLDQuestions.rideBooking.strategies.CashPaymentStrategy;
import commonLLDQuestions.rideBooking.strategies.DefaultPricingStrategy;
import commonLLDQuestions.rideBooking.strategies.PricingStrategy;

import java.util.Date;
import java.util.List;

public class RideSharing {

    private static CustomerService customerService;
    private static DriverService driverService;
    private static VehicleService vehicleService;
    private static BookingService bookingService;
    private static PaymentService paymentService;
    private static PricingStrategy pricingStrategy;

    private static void initialize() {
        customerService = new CustomerService();
        driverService = new DriverService();
        vehicleService = new VehicleService();
        pricingStrategy = new DefaultPricingStrategy();
        bookingService = new BookingService(pricingStrategy);
        paymentService = new PaymentService();

    }

    public static void main(String[] args) {

        initialize();

        //create and add user

        Customer customer1 = new Customer("customer1", UserType.CUSTOMER);
        Customer customer2 = new Customer("customer2", UserType.CUSTOMER);

        customerService.addCustomer(customer1);
        customerService.addCustomer(customer2);

        //create and add driver

        Driver driver1 = new Driver("driver1", UserType.DRIVER);
        Driver driver2 = new Driver("driver2", UserType.DRIVER);
        Driver driver3 = new Driver("driver3", UserType.DRIVER);

        driverService.addDriver(driver1);
        driverService.addDriver(driver2);
        driverService.addDriver(driver3);

        //create and add vehicle

        Vehicle vehicle1 = new Vehicle("1", VehicleType.BIKE);
        Vehicle vehicle2 = new Vehicle("2", VehicleType.AUTO);
        Vehicle vehicle3 = new Vehicle("3", VehicleType.CAB);

        vehicleService.addVehicle(vehicle1);
        vehicleService.addVehicle(vehicle2);
        vehicleService.addVehicle(vehicle3);

        //add vehicle for driver
        driver1.setVehicleNo(vehicle1.getVehicleNo());
        driver2.setVehicleNo(vehicle2.getVehicleNo());
        driver3.setVehicleNo(vehicle3.getVehicleNo());

        Location pickupLocation = new Location(1,1);
        Location dropLocation = new Location(5,5);

        //set customer location: similar to getting lat and long from google maps and setting the user location
        customer1.setLocation(pickupLocation);

        //set location for driver
        Location driverLocation1 = new Location(2,2);
        Location driverLocation2 = new Location(1,1);
        Location driverLocation3 = new Location(3,3);

        driver1.setLocation(driverLocation1);
        driver2.setLocation(driverLocation2);
        driver3.setLocation(driverLocation3);


        //get price for all three types of vehicles
        PricingStrategy pricingStrategy = new DefaultPricingStrategy();
        List<Double> prices = pricingStrategy.calculatePrice(pickupLocation, dropLocation);
        double bikePrice = prices.get(0);
        double autoPrice = prices.get(1);
        double cabPrice = prices.get(2);

        try {
            Booking booking = bookingService.bookVehicle(customer1.getUserId(),VehicleType.AUTO, autoPrice);

            PaymentStatus paymentStatus = paymentService.makePayment(autoPrice, booking.getBookingId(), new CashPaymentStrategy());

            Booking cancelledBooking  = bookingService.cancelBooking(booking.getBookingId());
            System.out.println("booking is cancelled with status: " + cancelledBooking.getBookingStatus());

        } catch (NoDriverAvailableException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //similarly other flows
    }
}
