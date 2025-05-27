package commonLLDQuestions.rideBooking.repository;

import commonLLDQuestions.rideBooking.entity.Driver;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DriverRepo {

    private Map<Integer, Driver> drivers;

    private DriverRepo() {
        this.drivers = new ConcurrentHashMap<>();
    }

    private static class Initializer {
        private static final DriverRepo INSTANCE = new DriverRepo();
    }

    public static DriverRepo getInstance(){
        return DriverRepo.Initializer.INSTANCE;
    }
}
