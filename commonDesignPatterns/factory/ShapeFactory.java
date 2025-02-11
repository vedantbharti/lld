package commonDesignPatterns.factory;

public class ShapeFactory {

    public Shape getShape(String shape){
        switch(shape){
            case "circle":
                return new Circle();
            case "rectangle":
                return new Rectangle();
            case "triangle":
                return new Triangle();
            default:
                return null;
        }
    }
}
