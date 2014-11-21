package org.pvytykac.structural.decorator;

public class ExtraCheeseDecorator extends PizzaDecorator {

    public ExtraCheeseDecorator(Pizza decoratedPizza) {
        super(decoratedPizza, Constants.EXTRA_CHEESE_DESC, Constants.EXTRA_CHEESE_PRICE);
    }
}
