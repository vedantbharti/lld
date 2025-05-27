package commonLLDQuestions.rideBooking.repository;

import commonLLDQuestions.rideBooking.entity.Vehicle;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VehicleRepo {

    private Map<String, Vehicle> vehicles;

    private VehicleRepo() {
        this.vehicles = new ConcurrentHashMap<>();
    }

    private static class Initializer {
        private static final VehicleRepo INSTANCE = new VehicleRepo();
    }

    public static VehicleRepo getInstance(){
        return VehicleRepo.Initializer.INSTANCE;
    }
}
