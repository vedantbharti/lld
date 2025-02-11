package commonDesignPatterns.strategy.withStrategy;


import commonDesignPatterns.strategy.withStrategy.driveStrategy.SpecialDriveStrategy;

public class SportsVehicle extends Vehicle{
    public SportsVehicle(SpecialDriveStrategy driveStrategy) {
        super(driveStrategy);
    }
}
