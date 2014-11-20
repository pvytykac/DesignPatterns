package org.pvytykac.behavioral.interpreter;

public class Number implements Expression {

    private int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public int interpret() {
        return value;
    }
}
