package commonDesignPatterns.abstractFactory;

public class LuxuryFactory {

    public Vehicle getLuxuryVehicle(String input){
        switch(input){
            case "bmw":
                return new BMW();
            case "mercedes":
                return new Mercedes();
            default:
                return null;
        }
    }
}
