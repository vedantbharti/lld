package commonDesignPatterns.decorator.decoratorClasses;

import commonDesignPatterns.decorator.baseClasses.BasePizza;

public class ExtraToppingsDecorator implements BasePizza {

    BasePizza basePizza;

    public ExtraToppingsDecorator(BasePizza basePizza){
        this.basePizza = basePizza;
    }
    @Override
    public int cost() {
        return basePizza.cost() + 100;
    }
}
