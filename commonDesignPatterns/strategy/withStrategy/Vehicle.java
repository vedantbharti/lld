package commonDesignPatterns.strategy.withStrategy;

import commonDesignPatterns.strategy.withStrategy.driveStrategy.DriveStrategy;

public class Vehicle {

    public DriveStrategy driveStrategy;

    public Vehicle(DriveStrategy driveStrategy){
        this.driveStrategy = driveStrategy;
    }
}
