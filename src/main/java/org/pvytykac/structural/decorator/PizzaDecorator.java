package org.pvytykac.structural.decorator;

public abstract class PizzaDecorator implements Pizza {

    private Pizza decoratedPizza;
    private String description;
    private double price;

    protected PizzaDecorator(Pizza decoratedPizza, String description, double price) {
        this.decoratedPizza = decoratedPizza;
        this.description = description;
        this.price = price;
    }

    @Override
    public String getDescription() {
        return decoratedPizza.getDescription() + ", " + this.description;
    }

    @Override
    public double getPrice() {
        return decoratedPizza.getPrice() + this.price;
    }
}
