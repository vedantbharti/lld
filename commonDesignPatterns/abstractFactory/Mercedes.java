package commonDesignPatterns.abstractFactory;

public class Mercedes implements LuxuryVehicle{

    @Override
    public void about() {
        System.out.println("Mercedes has a great luxury experience");
    }
}
