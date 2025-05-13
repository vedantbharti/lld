package commonLLDQuestions.carRental;

import commonLLDQuestions.carRental.entities.Store;
import commonLLDQuestions.carRental.entities.User;
import commonLLDQuestions.carRental.entities.Vehicle;
import commonLLDQuestions.carRental.enums.VehicleType;
import commonLLDQuestions.carRental.models.Location;
import commonLLDQuestions.carRental.service.*;

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
        Store store2 = new Store(1, location2);

        storeService.addStore(store1);
        storeService.addStore(store2);

        //add vehicles to stores
        storeService.addVehiclesToStore(store1.getStoreId(),vehicle1);
        storeService.addVehiclesToStore(store1.getStoreId(),vehicle2);
        storeService.addVehiclesToStore(store2.getStoreId(),vehicle2);
        storeService.addVehiclesToStore(store2.getStoreId(),vehicle4);

        //get all stores based on location
        List<Store> stores = storeService.getStoresForLocation(location1);

        //for a particular store, get all available vehicles with vehicleTypes
        List<Vehicle> twoWheelers = storeService.getAvailableVehicle(stores.get(0).getStoreId(),VehicleType.TWO_WHEELER);
        List<Vehicle> fourWheelers = storeService.getAvailableVehicle(stores.get(1).getStoreId(),VehicleType.FOUR_WHEELER);

        //TODO: select a vehicle to book

    }
}
