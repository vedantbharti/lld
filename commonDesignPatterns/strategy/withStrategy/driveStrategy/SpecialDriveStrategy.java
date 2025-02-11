package commonDesignPatterns.strategy.withStrategy.driveStrategy;

public class SpecialDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Some special drive capability");
    }
}
