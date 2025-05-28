package commonLLDQuestions.rideBooking.repository;

import commonLLDQuestions.rideBooking.entity.Driver;
import commonLLDQuestions.rideBooking.enums.VehicleType;
import commonLLDQuestions.rideBooking.model.Location;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DriverRepo {

    private Map<String, Driver> drivers;

    private DriverRepo() {
        this.drivers = new ConcurrentHashMap<>();
    }

    private static class Initializer {
        private static final DriverRepo INSTANCE = new DriverRepo();
    }

    public static DriverRepo getInstance(){
        return DriverRepo.Initializer.INSTANCE;
    }

    public void addDriver(Driver driver) {
        drivers.put(driver.getUserId(), driver);
    }

    public List<Driver> getAllDrivers(){
        return drivers.values().stream().toList();
    }
}
