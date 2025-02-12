package commonDesignPatterns.abstractFactory;

public class BMW implements LuxuryVehicle{
    @Override
    public void about() {
        System.out.println("BMW also has a great luxury experience");
    }
}
