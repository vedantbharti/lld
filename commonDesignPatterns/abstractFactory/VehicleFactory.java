package commonDesignPatterns.abstractFactory;

public class VehicleFactory {

    CommercialFactory commercialFactory = new CommercialFactory();
    LuxuryFactory luxuryFactory = new LuxuryFactory();

    Vehicle vehicle;
    public Vehicle getVehicle(String input){
        if(input.equals("swift") || input.equals("thar")){
            vehicle =  commercialFactory.getCommercialVehicle(input);
        } else if(input.equals("bmw") || input.equals("mercedes")){
            vehicle =  luxuryFactory.getLuxuryVehicle(input);
        } else {
            vehicle = null;
        }

        return vehicle;
    }
}
