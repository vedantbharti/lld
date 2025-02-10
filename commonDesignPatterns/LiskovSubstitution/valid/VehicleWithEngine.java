package commonDesignPatterns.LiskovSubstitution.valid;

import commonDesignPatterns.LiskovSubstitution.valid.Vehicle;

public class VehicleWithEngine extends Vehicle {

    public boolean startEngine(){
        return true;
    }
}
