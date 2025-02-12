package commonDesignPatterns.abstractFactory;

public class Main {

    public static void main(String[] args) {

        //Another design pattern is Abstract factory.
        //Suppose we have one interface CommercialVehicle and another interface LuxuryVehicle each implemented by respective many classes
        //We have one extra layer where we handle the logic to return each groups object
        //So we have a factory class for each of the groups and one more factory for getting each group depending on the input.
        //The factory classes which are returning the desired object are abstracted away by the wrapper factory, hence abstract factory class

        VehicleFactory vehicleFactory = new VehicleFactory();

        Vehicle swift = vehicleFactory.getVehicle("bmw");
        Vehicle thar = vehicleFactory.getVehicle("thar");
        Vehicle mercedes = vehicleFactory.getVehicle("mercedes");
        Vehicle bmw = vehicleFactory.getVehicle("bmw");

        swift.about();
        thar.about();
        mercedes.about();
        bmw.about();


    }
}
