package commonDesignPatterns.strategy.withoutStrategy;

public class SportsVehicle extends Vehicle {

    @Override
    public void drive(){
        System.out.println("Some special drive capability");
    }
}
