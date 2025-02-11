package commonDesignPatterns.strategy.withoutStrategy;

public class GoodsVehicle extends Vehicle{

    @Override
    public void drive() {
        System.out.println("Some special drive capability");
    }
}
