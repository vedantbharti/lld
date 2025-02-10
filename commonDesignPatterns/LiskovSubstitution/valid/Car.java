package commonDesignPatterns.LiskovSubstitution.valid;

import commonDesignPatterns.LiskovSubstitution.valid.VehicleWithEngine;

public class Car extends VehicleWithEngine {

    @Override
    public int numberOfWheels(){
        return 4;
    }
}
