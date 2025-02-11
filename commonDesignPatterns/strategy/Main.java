package commonDesignPatterns.strategy;

import commonDesignPatterns.strategy.withStrategy.driveStrategy.NormalDriveStrategy;
import commonDesignPatterns.strategy.withStrategy.driveStrategy.SpecialDriveStrategy;
import commonDesignPatterns.strategy.withoutStrategy.GoodsVehicle;
import commonDesignPatterns.strategy.withoutStrategy.PassengerVehicle;
import commonDesignPatterns.strategy.withoutStrategy.SportsVehicle;

public class Main {

    public static void main(String[] args) {

        //without strategy pattern: used for is-a relationship to avoid code duplicacy
        //whenever we create a new child class, we will have a repeatitive code of drive
        //even though there might be cases when some of the child classes have same logic needed
        //and in that case the code will be duplicated

        //solution: strategy pattern
        //Let's create a capability interface and each of the different capability be implemented by some class
        //Now the classes using these capability will just be creating the object of the child of the interface instead
        //of duplicating the same code.

        //increases extensibility, reusability, and reduces duplicability

        PassengerVehicle passengerVehicle = new PassengerVehicle();
        SportsVehicle sportsVehicle = new SportsVehicle();
        GoodsVehicle goodsVehicle = new GoodsVehicle();

        passengerVehicle.drive();
        sportsVehicle.drive();
        goodsVehicle.drive();


        commonDesignPatterns.strategy.withStrategy.PassengerVehicle passengerVehicle1 = new commonDesignPatterns.strategy.withStrategy.PassengerVehicle(new NormalDriveStrategy());
        commonDesignPatterns.strategy.withStrategy.SportsVehicle sportsVehicle1 = new commonDesignPatterns.strategy.withStrategy.SportsVehicle(new SpecialDriveStrategy());
        commonDesignPatterns.strategy.withStrategy.GoodsVehicle goodsVehicle1 = new commonDesignPatterns.strategy.withStrategy.GoodsVehicle(new SpecialDriveStrategy());

        passengerVehicle1.driveStrategy.drive();
        sportsVehicle1.driveStrategy.drive();
        goodsVehicle1.driveStrategy.drive();

    }
}
