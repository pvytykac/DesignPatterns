package org.pvytykac.behavioral.state;

public interface State {

    public void insertQuarter(GumballMachine machine) throws StateException;
    public void ejectQuarter(GumballMachine machine) throws StateException;
    public void turnCrank(GumballMachine machine) throws StateException;
    public void dispense(GumballMachine machine) throws StateException;
    public void refill(GumballMachine machine, int amount) throws StateException;

}
