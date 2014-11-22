package org.pvytykac.behavioral.state;

public class SoldState implements State {

    @Override
    public void insertQuarter(GumballMachine machine) throws StateException {
        throw new StateException("Wait for the gumball to be dispensed.");
    }

    @Override
    public void ejectQuarter(GumballMachine machine) throws StateException {
        throw new StateException("There is no quarter to eject.");
    }

    @Override
    public void turnCrank(GumballMachine machine) throws StateException {
        throw new StateException("You already turned the crank.");
    }

    @Override
    public void dispense(GumballMachine machine) throws StateException {
        machine.setNumberOfBalls(machine.getNumberOfBalls() - 1);
        System.out.println("The ball has been dispensed.");
        if(machine.getNumberOfBalls() > 0){
            machine.setState(GumballMachine.getNoQuarterState());
        }else{
            machine.setState(GumballMachine.getSoldOutState());
        }
    }
}
