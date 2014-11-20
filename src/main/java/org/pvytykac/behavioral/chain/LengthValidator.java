package org.pvytykac.behavioral.chain;

public class LengthValidator extends Validator<String> {

    private int minLength;

    public LengthValidator(int minLength) {
        this.minLength = minLength;
    }

    @Override
    protected boolean validate(String value) {
        return value != null && value.length() >= minLength;
    }
}
