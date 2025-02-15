package commonDesignPatterns.decorator.decoratorClasses;

import commonDesignPatterns.decorator.baseClasses.BasePizza;

public class ExtraCheeseDecorator implements ToppingDecorator{

    BasePizza basePizza;

    public ExtraCheeseDecorator(BasePizza basePizza) {
        this.basePizza = basePizza;
    }
    @Override
    public int cost() {
        return basePizza.cost() + 50;
    }
}
