package org.pvytykac.behavioral.strategy;

public class Character {

    private int damage;
    private FightStrategy fightStrategy;

    public Character(int damage, FightStrategy fightStrategy) {
        this.damage = damage;
        this.fightStrategy = fightStrategy;
    }

    public void fight(){
        DamageInfo dmgInfo = fightStrategy.hit(damage);
        System.out.println("damage: " + dmgInfo.getValue() + ", " + dmgInfo.getType());
    }

    public void setFightStrategy(FightStrategy fightStrategy) {
        this.fightStrategy = fightStrategy;
    }
}
