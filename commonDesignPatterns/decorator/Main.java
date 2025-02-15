package commonDesignPatterns.decorator;

import commonDesignPatterns.decorator.baseClasses.BasePizza;
import commonDesignPatterns.decorator.baseClasses.ChickenDelight;
import commonDesignPatterns.decorator.baseClasses.FarmhousePizza;
import commonDesignPatterns.decorator.baseClasses.MargheritaPizza;
import commonDesignPatterns.decorator.decoratorClasses.ExtraCheeseDecorator;
import commonDesignPatterns.decorator.decoratorClasses.ExtraToppingsDecorator;

public class Main {

    public static void main(String[] args) {

        //decorator pattern basically makes it easier to have multiple combinations of different extra features over a
        //a base class and create different new classes.
        //It helps avoid class explosion(when you need several combinations of features over a single base class and you
        //end up making lots of classes just for multiple combinations)
        //The decorator object has both "is-a" and "has-a" relationship with the base object


        BasePizza farmhouse = new FarmhousePizza();
        System.out.println("cost of farmhouse pizza is: " + farmhouse.cost());
        BasePizza margherita = new MargheritaPizza();
        System.out.println("cost of margherita pizza is: " + margherita.cost());
        BasePizza chickenDelight = new ChickenDelight();
        System.out.println("cost of chicken delight pizza is: " + chickenDelight.cost());
        BasePizza chickenWithExtraCheese = new ExtraCheeseDecorator(chickenDelight);
        System.out.println("cost of chicken delight with extra cheese pizza is: " + chickenWithExtraCheese.cost());
        BasePizza margheritaWithExtraToppings = new ExtraToppingsDecorator(margherita);
        System.out.println("cost of margherita with extra toppings pizza is: " + margheritaWithExtraToppings.cost());
    }
}
