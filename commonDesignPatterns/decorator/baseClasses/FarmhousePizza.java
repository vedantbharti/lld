package commonDesignPatterns.decorator.baseClasses;

public class FarmhousePizza implements BasePizza{

    @Override
    public int cost() {
        return 200;
    }
}
