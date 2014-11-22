package org.pvytykac.behavioral.state;

import org.junit.Test;
import static org.junit.Assert.*;

public class StateTest {

    @Test
    public void stateTest(){
        int count = 5;
        GumballMachine machine = new GumballMachine(count);

        try{
            for(int i = 0; i < count; i++){
                machine.insertQuarter();
                machine.turnCrank();
            }

        }catch(Exception ex){
            fail("test failed due to exception: " + ex.getMessage());
        }

        try {
            machine.insertQuarter();
            machine.turnCrank();
        }catch(StateException ex){
            System.err.println(ex.getMessage());
            assertEquals("The gumball machine is sold out.", ex.getMessage());
            return;
        }

        fail("test failed due to the expected exception not being thrown.");
    }

}
