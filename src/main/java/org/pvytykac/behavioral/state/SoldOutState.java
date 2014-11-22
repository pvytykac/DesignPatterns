package org.pvytykac.behavioral.state;

public class SoldOutState implements State {

    @Override
    public void insertQuarter(GumballMachine machine) throws StateException {
        System.out.println("You have inserted a quarter.");
        ejectQuarter(machine);
    }

    @Override
    public void ejectQuarter(GumballMachine machine) throws StateException {
        System.out.println("The quarter has been ejected.");
    }

    @Override
    public void turnCrank(GumballMachine machine) throws StateException {
        throw new StateException("The gumball machine is sold out.");
    }

    @Override
    public void dispense(GumballMachine machine) throws StateException {
        throw new StateException("The gumball machine is sold out.");
    }

    @Override
    public void refill(GumballMachine machine, int amount) throws StateException {
        machine.setNumberOfBalls(amount);
        machine.setState(GumballMachine.getNoQuarterState());
        System.out.println("The empty machine has been refilled with " + amount + " gumballs.");
    }
}
