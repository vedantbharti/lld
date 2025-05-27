package commonLLDQuestions.rideBooking.service;

import commonLLDQuestions.rideBooking.repository.DriverRepo;

public class DriverService {

    private final DriverRepo driverRepo;

    public DriverService() {
        this.driverRepo = DriverRepo.getInstance();
    }
}
