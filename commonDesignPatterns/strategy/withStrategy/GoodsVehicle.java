package commonDesignPatterns.strategy.withStrategy;

import commonDesignPatterns.strategy.withStrategy.driveStrategy.SpecialDriveStrategy;

public class GoodsVehicle extends Vehicle{
    public GoodsVehicle(SpecialDriveStrategy driveStrategy) {
        super(driveStrategy);
    }
}
