package org.pvytykac.behavioral.strategy;

import org.junit.Test;

public class StrategyTest {

    @Test
    public void strategyTest(){
        Character c = new Character(100, new MeleeFightStrategy());
        for(int i = 0; i < 20; i++)
            c.fight();

        c.setFightStrategy(new SpellFightStrategy());
        for(int i = 0; i < 20; i++)
            c.fight();
    }

}
