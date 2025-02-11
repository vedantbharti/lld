package commonDesignPatterns.strategy.withStrategy;

import commonDesignPatterns.strategy.withStrategy.driveStrategy.NormalDriveStrategy;

public class PassengerVehicle extends Vehicle{
    public PassengerVehicle(NormalDriveStrategy driveStrategy) {
        super(driveStrategy);
    }
}
