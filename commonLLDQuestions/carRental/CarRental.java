package commonLLDQuestions.carRental;

import commonLLDQuestions.carRental.entities.Booking;
import commonLLDQuestions.carRental.entities.Store;
import commonLLDQuestions.carRental.entities.User;
import commonLLDQuestions.carRental.entities.Vehicle;
import commonLLDQuestions.carRental.enums.BookingStatus;
import commonLLDQuestions.carRental.enums.VehicleType;
import commonLLDQuestions.carRental.exception.VehicleAlreadyAddedException;
import commonLLDQuestions.carRental.models.Location;
import commonLLDQuestions.carRental.service.*;

import java.util.Date;
import java.util.List;

public class CarRental {

    private static UserService userService = new UserService();
    private static VehicleService vehicleService = new VehicleService();
    private static StoreService storeService = new StoreService();
    private static PaymentService paymentService = new PaymentService();
    private static BookingService bookingService = new BookingService();

    public static void main(String[] args) {

        //create objects
        intialize();

        //tried chain of responsibility design pattern in this question
    }

    public static void intialize() {

        //create users
        User user1 = new User(1,"User1");
        User user2 = new User(2,"User2");

        userService.addUser(user1);
        userService.addUser(user2);

        Location location1 = new Location("address1", "city1", "state1", "country1", 1);
        Location location2 = new Location("address2", "city2", "state2", "country2", 2);

        //create vehicles
        Vehicle vehicle1 = new Vehicle(1, "V1", VehicleType.TWO_WHEELER);
        Vehicle vehicle2 = new Vehicle(2, "V2", VehicleType.TWO_WHEELER);
        Vehicle vehicle3 = new Vehicle(3, "V3", VehicleType.FOUR_WHEELER);
        Vehicle vehicle4 = new Vehicle(4, "V4", VehicleType.FOUR_WHEELER);

        vehicleService.addVehicle(vehicle1);
        vehicleService.addVehicle(vehicle2);
        vehicleService.addVehicle(vehicle3);
        vehicleService.addVehicle(vehicle4);

        //create stores
        Store store1 = new Store(1,location1);
        Store store2 = new Store(2, location2);

        storeService.addStore(store1);
        storeService.addStore(store2);

        //add vehicles to stores
        try {
            storeService.addVehiclesToStore(store1.getStoreId(),vehicle1);
            storeService.addVehiclesToStore(store1.getStoreId(),vehicle3);
            storeService.addVehiclesToStore(store2.getStoreId(),vehicle2);
            storeService.addVehiclesToStore(store2.getStoreId(),vehicle4);
        } catch (VehicleAlreadyAddedException e) {
            System.out.println(e.getMessage());
        }

        //get all stores based on location
        List<Store> stores = storeService.getStoresForLocation(location1);

        //for a particular store, get all available vehicles with vehicleTypes
        List<Vehicle> twoWheelers = storeService.getAvailableVehicles(stores.get(0).getStoreId(),VehicleType.TWO_WHEELER);
        List<Vehicle> fourWheelers = storeService.getAvailableVehicles(stores.get(0).getStoreId(),VehicleType.FOUR_WHEELER);

        //TODO: select a vehicle to book

        Vehicle selectedTwoWheeler = twoWheelers.get(0);
        Vehicle selectedFourWheeler = fourWheelers.get(0);

        Booking booking1 = bookingService.bookVehicle(1,user1.getUserId(),selectedTwoWheeler, new Date(2025,05,15), new Date(2025,05,17));
        Booking booking2 = bookingService.bookVehicle(2,user2.getUserId(),selectedFourWheeler, new Date(2025,05,20), new Date(2025,05,22));

        // complete ride and return vehicle
        booking1.setBookingStatus(BookingStatus.COMPLETED);
        System.out.println("booking1 is completed with following details: " +
                "vehicle number: " + booking1.getVehicleNo() + " " +
                "user id: " + booking1.getUserId() + " " +
                "payment id: " + booking1.getPaymentId() + " " +
                "booking status: " + booking1.getBookingStatus()
        );

        System.out.println("payment status is: " + paymentService.getPaymentDetails(booking1.getPaymentId()).getPaymentStatus());

        //cancel Booking
        Booking cancelledBooking = bookingService.cancelBooking(booking2.getBookingId());

        System.out.println("booking2 is cancelled with following details: " +
                "vehicle number: " + booking2.getVehicleNo() + " " +
                "user id: " + booking2.getUserId() + " " +
                "payment id: " + booking2.getPaymentId() + " " +
                "booking status: " + booking2.getBookingStatus()
        );

        System.out.println("payment status is: " + paymentService.getPaymentDetails(booking2.getPaymentId()).getPaymentStatus());

    }
}
