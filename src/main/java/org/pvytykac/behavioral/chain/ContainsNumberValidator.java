package org.pvytykac.behavioral.chain;

public class ContainsNumberValidator extends Validator<String> {

    @Override
    protected boolean validate(String value) {
        return value != null && value.matches(".*\\d.*");
    }
}
