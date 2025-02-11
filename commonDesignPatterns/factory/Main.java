package commonDesignPatterns.factory;

public class Main {

    public static void main(String[] args) {

        //Factory design pattern helps us return different objects depending on different input.
        //Factory method basically implements a logic to return the desired object based on the provided input
        //This helps us with code extensibility, loose coupling and reusability

        //Another design pattern is Abstract factory.
        //Suppose we have one interface Shape and another interface Vehicles each implemented by respective many classes
        //We have one extra layer where we handle the logic to return each groups object
        //So we have a factory class which will provide us


        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = shapeFactory.getShape("circle");
        Shape rectangle = shapeFactory.getShape("rectangle");
        Shape triangle = shapeFactory.getShape("triangle");


        circle.shape();
        rectangle.shape();
        triangle.shape();
    }
}
