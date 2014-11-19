package org.pvytykac.behavioral.strategy;

import java.util.Random;

public class SpellFightStrategy implements FightStrategy {

    private Random random = new Random();

    private static final double MISS_CHANCE = 0.2D;
    private static final double CRIT_CHANCE = 0.2D;
    private static final double RESIST_CHANCE = 0.05D;

    @Override
    public DamageInfo hit(double damage) {
        double roll = random.nextDouble();
        if(roll <= MISS_CHANCE)
            return new DamageInfo(0, DamageType.MISS);

        roll = random.nextDouble();
        if(roll <= RESIST_CHANCE)
            return new DamageInfo(0.25D * damage, DamageType.RESIST);

        roll = random.nextDouble();
        if(roll <= CRIT_CHANCE)
            return new DamageInfo(2D * damage, DamageType.CRIT);
        else
            return new DamageInfo(damage, DamageType.SPELL);
    }
}
