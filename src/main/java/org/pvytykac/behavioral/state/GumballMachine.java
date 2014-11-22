package org.pvytykac.behavioral.state;

public class GumballMachine {

    private State state;
    private int numberOfBalls;

    private static final State hasQuarterState = new HasQuarterState();
    private static final State noQuarterState  = new NoQuarterState();
    private static final State soldOutState    = new SoldOutState();
    private static final State soldState       = new SoldState();

    public GumballMachine(int numberOfBalls) {
        this.numberOfBalls = numberOfBalls;
        if(numberOfBalls > 0)
            this.state = noQuarterState;
        else
            this.state = soldOutState;
    }

    public void insertQuarter() throws StateException {
        state.insertQuarter(this);
    }

    public void turnCrank() throws StateException {
        state.turnCrank(this);
        state.dispense(this);
    }

    public void refill(int amount) throws StateException {
        state.refill(this, amount);
    }

    public static State getHasQuarterState() {
        return hasQuarterState;
    }

    public static State getNoQuarterState() {
        return noQuarterState;
    }

    public static State getSoldOutState() {
        return soldOutState;
    }

    public static State getSoldState() {
        return soldState;
    }

    public int getNumberOfBalls() {
        return numberOfBalls;
    }

    protected void setState(State state) {
        this.state = state;
    }

    protected void setNumberOfBalls(int numberOfBalls){
        this.numberOfBalls = numberOfBalls;
    }

}
