package org.pvytykac.behavioral.state;

import org.junit.Test;
import static org.junit.Assert.*;

public class StateTest {

    @Test
    public void stateTest(){
        int count = 5;
        StateException expectedException = null;
        GumballMachine machine = new GumballMachine(count);

        // insert quarters and turn the crank untill the machine is empty
        // no exception should be thrown
        try{
            for(int i = 0; i < count; i++){
                machine.insertQuarter();
                machine.turnCrank();
            }
        }catch(Exception ex){
            fail("test failed due to exception: " + ex.getMessage());
        }

        // try to insert quarter to an empty machine and turn the crank
        // the quarter should be ejected and an exception should be thrown expected
        try {
            machine.insertQuarter();
            machine.turnCrank();
        }catch(StateException ex){
            System.err.println(ex.getMessage());
            assertEquals("The gumball machine is sold out.", ex.getMessage());
            expectedException = ex;
        }

        // if no exception was thrown ^, fail the test
        if(expectedException == null){
            fail("test failed due to the expected exception not being thrown.");
        }
        expectedException = null;

        // refill the machine with 5 gumballs and try to buy another one
        // no exception should be thrown
        try{
            machine.refill(5);
            machine.insertQuarter();
            machine.turnCrank();
        }catch(StateException ex){
            fail("test failed due to exception: " + ex.getMessage());
        }

        // try to refill with a quarter inserted
        // exception should be thrown
        try {
            count = machine.getNumberOfBalls();
            machine.insertQuarter();
            machine.refill(5);
            machine.turnCrank();
        }catch(StateException ex){
            System.err.println(ex.getMessage());
            assertEquals("You cannot refill the machine at this moment.", ex.getMessage());
            assertEquals(count, 4);
            expectedException = ex;
        }

        // if no exception was thrown ^, fail the test
        if(expectedException == null){
            fail("test failed due to the expected exception not being thrown.");
        }
        expectedException = null;

        // try to refill in a no quarter state
        // the machine should be refilled, state should not change
        try {
            machine.turnCrank();
            count = machine.getNumberOfBalls();
            machine.refill(5);
            assertEquals(count + 5, machine.getNumberOfBalls());
        }catch(StateException ex){
            fail("test failed due to exception: " + ex.getMessage());
        }
    }

}
