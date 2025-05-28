package commonLLDQuestions.rideBooking.service;

import commonLLDQuestions.rideBooking.entity.Customer;
import commonLLDQuestions.rideBooking.entity.Driver;
import commonLLDQuestions.rideBooking.entity.Vehicle;
import commonLLDQuestions.rideBooking.enums.VehicleType;
import commonLLDQuestions.rideBooking.model.Location;
import commonLLDQuestions.rideBooking.repository.DriverRepo;

import java.util.List;
import java.util.stream.Collectors;

public class DriverService {

    private final DriverRepo driverRepo;
    private final VehicleService vehicleService;

    public DriverService() {
        this.driverRepo = DriverRepo.getInstance();
        this.vehicleService = new VehicleService();
    }

    public synchronized void addDriver(Driver driver) {
        driverRepo.addDriver(driver);
    }

    public List<Driver> getAllDrivers(){
        return driverRepo.getAllDrivers();
    }

    public List<Driver> findAvailableDriversWithinRange(Location pickupLocation, VehicleType vehicleType) {
        List<Driver> drivers = getAllDrivers();
        return drivers.stream().filter(driver -> {
            String vehicleNo = driver.getVehicleNo();
            Vehicle vehicle = vehicleService.getVehicleByNumber(vehicleNo);
            return vehicle.getVehicleType().equals(vehicleType);
        }).filter(driver -> {
            Location driverLocation = driver.getLocation();
            double dist = Math.sqrt(
                    (driverLocation.getLatitude()-pickupLocation.getLatitude())*(driverLocation.getLatitude()-pickupLocation.getLatitude()) +
                            (driverLocation.getLongitude()-pickupLocation.getLongitude())*(driverLocation.getLongitude()-pickupLocation.getLongitude())
            );
            if(dist<3) return true;
            return false;
        }).collect(Collectors.toList());
    }
}
