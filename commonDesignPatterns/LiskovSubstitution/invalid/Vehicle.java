package commonDesignPatterns.LiskovSubstitution.invalid;

public class Vehicle {

    public int numberOfWheels(){
        return 2;
    }

    public boolean startEngine(){
        return true;
    }
}
