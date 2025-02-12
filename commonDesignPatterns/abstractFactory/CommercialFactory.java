package commonDesignPatterns.abstractFactory;

public class CommercialFactory {

    public Vehicle getCommercialVehicle(String input){
        switch(input){
            case "swift":
                return new Swift();
            case "thar":
                return new Thar();
            default:
                return null;
        }
    }
}
