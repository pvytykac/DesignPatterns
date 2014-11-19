package org.pvytykac.behavioral.strategy;

public class DamageInfo {

    private final double value;
    private final DamageType type;

    public DamageInfo(double value, DamageType type) {
        this.value = value;
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public DamageType getType() {
        return type;
    }
}
