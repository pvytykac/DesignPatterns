package org.pvytykac.behavioral.state;

public class HasQuarterState implements State {

    @Override
    public void insertQuarter(GumballMachine machine) throws StateException{
        throw new StateException("You can not insert another quarter.");
    }

    @Override
    public void ejectQuarter(GumballMachine machine) throws StateException {
        machine.setState(GumballMachine.getNoQuarterState());
        System.out.println("The quarter has been ejected.");
    }

    @Override
    public void turnCrank(GumballMachine machine) throws StateException {
        System.out.println("The crank has been turned.");
        machine.setState(GumballMachine.getSoldState());
    }

    @Override
    public void dispense(GumballMachine machine) throws StateException {
        throw new StateException("The ball can not be dispensed, you need to turn the crank first.");
    }
}
