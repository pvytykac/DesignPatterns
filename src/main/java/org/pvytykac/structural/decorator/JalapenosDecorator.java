package org.pvytykac.structural.decorator;

public class JalapenosDecorator extends PizzaDecorator {

    public JalapenosDecorator(Pizza decoratedPizza) {
        super(decoratedPizza, Constants.JALAPENOS_DESC, Constants.JALAPENOS_PRICE);
    }
}
