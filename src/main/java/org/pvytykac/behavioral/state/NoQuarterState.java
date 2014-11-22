package org.pvytykac.behavioral.state;

public class NoQuarterState implements State {

    @Override
    public void insertQuarter(GumballMachine machine) throws StateException {
        System.out.println("You have inserted a quarter.");
        machine.setState(GumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter(GumballMachine machine) throws StateException{
        throw new StateException("There is no quarter to eject.");
    }

    @Override
    public void turnCrank(GumballMachine machine) throws StateException {
        throw new StateException("The crank is blocked, you need to insert a quarter first.");
    }

    @Override
    public void dispense(GumballMachine machine) throws StateException {
        throw new StateException("Insert a quarter then turn the crank.");
    }

    @Override
    public void refill(GumballMachine machine, int amount) throws StateException {
        machine.setNumberOfBalls(machine.getNumberOfBalls() + amount);
        System.out.println("The machine was refilled, gumballs before refill = "
                + (machine.getNumberOfBalls() - amount)
                + ", now = "
                + machine.getNumberOfBalls());
    }

}
