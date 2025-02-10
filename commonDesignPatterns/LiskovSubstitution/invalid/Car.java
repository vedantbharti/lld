package commonDesignPatterns.LiskovSubstitution.invalid;

public class Car extends Vehicle{

    @Override
    public int numberOfWheels(){
        return 4;
    }
}
