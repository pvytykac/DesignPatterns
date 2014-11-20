package org.pvytykac.behavioral.chain;

public abstract class Validator<T> {

    private Validator<T> next;

    protected abstract boolean validate(T value);

    public boolean isValid(T value){
        boolean valid = validate(value);
        if(valid && next != null){
            return next.isValid(value);
        }

        return valid;
    }

    public void setNext(Validator<T> validator){
        this.next = validator;
    }

}
