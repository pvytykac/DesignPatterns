package org.pvytykac.behavioral.chain;

public class ContainsUppercaseValidator extends Validator<String> {

    @Override
    protected boolean validate(String value) {
        return value != null && !value.equals(value.toLowerCase());
    }
}
