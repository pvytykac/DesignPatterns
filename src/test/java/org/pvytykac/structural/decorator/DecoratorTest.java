package org.pvytykac.structural.decorator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DecoratorTest {

    @Test
    public void decoratorTest(){
        TestCase[] testCases = new TestCase[]{
            new TestCase(new PizzaMargherita(), Constants.PIZZA_MARGHERITA_DESC, Constants.PIZZA_MARGHERITA_PRICE),
            new TestCase(new PizzaPepperoni(), Constants.PIZZA_PEPPERONI_DESC, Constants.PIZZA_PEPPERONI_PRICE)
        };

        for(TestCase testCase: testCases){
            Pizza pizza = testCase.getPizza();
            double expectedPrice = testCase.getExpectedPrice();
            String expectedDesc  = testCase.getExpectedDesc();
            assertEquals(pizza.getPrice(), expectedPrice, Double.MIN_VALUE);
            assertEquals(pizza.getDescription(), expectedDesc);

            pizza = new ExtraCheeseDecorator(pizza);
            expectedPrice += Constants.EXTRA_CHEESE_PRICE;
            expectedDesc += ", " + Constants.EXTRA_CHEESE_DESC;
            assertEquals(pizza.getPrice(), expectedPrice, Double.MIN_VALUE);
            assertEquals(pizza.getDescription(), expectedDesc);

            pizza = new ExtraOlivesDecorator(pizza);
            expectedPrice += Constants.EXTRA_OLIVES_PRICE;
            expectedDesc += ", " + Constants.EXTRA_OLIVES_DESC;
            assertEquals(pizza.getPrice(), expectedPrice, Double.MIN_VALUE);
            assertEquals(pizza.getDescription(), expectedDesc);

            pizza = new JalapenosDecorator(pizza);
            expectedDesc += ", " + Constants.JALAPENOS_DESC;
            expectedPrice += Constants.JALAPENOS_PRICE;
            assertEquals(pizza.getPrice(), expectedPrice, Double.MIN_VALUE);
            assertEquals(pizza.getDescription(), expectedDesc);

            System.out.println(pizza.getDescription() + ": " + pizza.getPrice() + "$");
        }
    }

    private class TestCase {

        private final Pizza pizza;
        private final String expectedDesc;
        private final double expectedPrice;

        private TestCase(Pizza pizza, String expectedDesc, double expectedPrice) {
            this.pizza = pizza;
            this.expectedDesc = expectedDesc;
            this.expectedPrice = expectedPrice;
        }

        private Pizza getPizza() {
            return pizza;
        }

        private String getExpectedDesc() {
            return expectedDesc;
        }

        private double getExpectedPrice() {
            return expectedPrice;
        }
    }

}
