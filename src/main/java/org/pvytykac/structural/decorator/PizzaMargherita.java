package org.pvytykac.structural.decorator;

public class PizzaMargherita implements Pizza {

    @Override
    public String getDescription() {
        return Constants.PIZZA_MARGHERITA_DESC;
    }

    @Override
    public double getPrice() {
        return Constants.PIZZA_MARGHERITA_PRICE;
    }
}
