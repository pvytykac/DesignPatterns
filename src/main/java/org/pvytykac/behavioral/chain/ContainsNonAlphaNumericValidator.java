package org.pvytykac.behavioral.chain;

public class ContainsNonAlphaNumericValidator extends Validator<String> {

    @Override
    protected boolean validate(String value) {
        if(value != null){
            for(char c: value.toCharArray())
                if((c < 'a' || c > 'z')
                    && (c < 'A' || c > 'Z')
                    && (c < '0' || c > '9')){
                    return true;
                }
        }

        return false;
    }
}
