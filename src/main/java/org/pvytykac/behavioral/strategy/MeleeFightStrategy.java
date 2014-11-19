package org.pvytykac.behavioral.strategy;

import java.util.Random;

public class MeleeFightStrategy implements FightStrategy {

    private Random random = new Random();

    private static final double MISS_CHANCE = 0.05;
    private static final double PARRY_CHANCE = 0.10;
    private static final double DODGE_CHANCE = 0.10;
    private static final double BLOCK_CHANCE = 0.15;
    private static final double CRIT_CHANCE = 0.30;

    @Override
    public DamageInfo hit(double damage) {
        double roll = random.nextDouble();
        if(roll <= MISS_CHANCE)
            return new DamageInfo(0, DamageType.MISS);

        roll = random.nextDouble();
        if(roll <= PARRY_CHANCE)
            return new DamageInfo(0, DamageType.PARRY);

        roll = random.nextDouble();
        if(roll <= DODGE_CHANCE)
            return new DamageInfo(0, DamageType.DODGE);

        roll = random.nextDouble();
        if(roll <= BLOCK_CHANCE)
            return new DamageInfo(0.5D * damage, DamageType.BLOCK);

        roll = random.nextDouble();
        if(roll <= CRIT_CHANCE)
            return new DamageInfo(2.5D * damage, DamageType.CRIT);
        else
            return new DamageInfo(damage, DamageType.MELEE);
    }
}
