package commonDesignPatterns.LiskovSubstitution;

import commonDesignPatterns.LiskovSubstitution.invalid.Bicycle;
import commonDesignPatterns.LiskovSubstitution.invalid.Bike;
import commonDesignPatterns.LiskovSubstitution.invalid.Car;
import commonDesignPatterns.LiskovSubstitution.invalid.Vehicle;
import commonDesignPatterns.LiskovSubstitution.valid.VehicleWithEngine;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Liskov principle says, a parent class object should be substitutable with the child class.
        //This substitution must not break the code

        //the invalid case breaks the code flow: uncomment and try
//        List<Vehicle> vehicles = new ArrayList<>();
//        vehicles.add(new Car());
//        vehicles.add(new Bike());
//        vehicles.add(new Bicycle());
//        for(Vehicle vehicle : vehicles){
//            System.out.println(vehicle.numberOfWheels());
//            //for this case, when vehicle is bicycle, it will throw exception hence breaking the code
//            System.out.println(vehicle.startEngine());
//        }

        //better and more valid way of writing code:
        List<commonDesignPatterns.LiskovSubstitution.valid.Vehicle> vehicles1 = new ArrayList<>();
        vehicles1.add(new commonDesignPatterns.LiskovSubstitution.valid.Car());
        vehicles1.add(new commonDesignPatterns.LiskovSubstitution.valid.Bike());
        vehicles1.add(new commonDesignPatterns.LiskovSubstitution.valid.Bicycle());
        for(commonDesignPatterns.LiskovSubstitution.valid.Vehicle vehicle : vehicles1){
            System.out.println(vehicle.numberOfWheels());
            //for this case, startEngine is not a method of Vehicle so we can't use it here.
//            System.out.println(vehicle.startEngine());
        }

        List<VehicleWithEngine> vehicles2 = new ArrayList<>();
        vehicles2.add(new commonDesignPatterns.LiskovSubstitution.valid.Car());
        vehicles2.add(new commonDesignPatterns.LiskovSubstitution.valid.Bike());
        //we can't add bicycle to the vehicles with engine because it doesn't extend it
        //vehicles2.add(new commonDesignPatterns.LiskovSubstitution.valid.Bicycle());
        for(VehicleWithEngine vehicle : vehicles2){
            System.out.println(vehicle.numberOfWheels());
            //for this case, startEngine is a method of VehicleWithEngine
            System.out.println(vehicle.startEngine());
        }

    }
}
