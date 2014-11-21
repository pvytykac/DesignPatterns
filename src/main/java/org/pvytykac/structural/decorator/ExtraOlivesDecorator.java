package org.pvytykac.structural.decorator;

public class ExtraOlivesDecorator extends PizzaDecorator {

    public ExtraOlivesDecorator(Pizza decoratedPizza) {
        super(decoratedPizza, Constants.EXTRA_OLIVES_DESC, Constants.EXTRA_OLIVES_PRICE);
    }

}
