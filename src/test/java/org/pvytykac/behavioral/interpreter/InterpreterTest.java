package org.pvytykac.behavioral.interpreter;

import org.junit.Test;
import static org.junit.Assert.*;

public class InterpreterTest {

    @Test
    public void interpreterTest(){
        try{
            // (1 + 2) - (3 - 4)
            Expression expression = new Minus(
                    new Plus(
                            new Number(1),
                            new Number(2)),
                    new Minus(
                            new Number(3),
                            new Number(4)));

            int value = expression.interpret();
            assertEquals(4, value);
        }catch(Exception ex){
            fail("test failed due to exception: " + ex.getMessage());
        }
    }

}
