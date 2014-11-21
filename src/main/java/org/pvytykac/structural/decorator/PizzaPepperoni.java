package org.pvytykac.structural.decorator;

public class PizzaPepperoni implements Pizza {

    @Override
    public String getDescription() {
        return Constants.PIZZA_PEPPERONI_DESC;
    }

    @Override
    public double getPrice() {
        return Constants.PIZZA_PEPPERONI_PRICE;
    }
}
