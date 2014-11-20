package org.pvytykac.behavioral.chain;

import org.junit.Test;
import static org.junit.Assert.*;

public class ChainTest {

    @Test
    public void chainTest(){
        Validator<String> validator = createValidator();

        // invalid: too short
        String password = "P1#";
        assertFalse(validator.isValid(password));

        // invalid: no number, no uppercase, no non-alphanumeric
        password = "password";
        assertFalse(validator.isValid(password));

        // invalid: no uppercase, no non-alphanumeric
        password = "passw0rd";
        assertFalse(validator.isValid(password));

        // invalid: no non-alphanumeric
        password = "Passw0rd";
        assertFalse(validator.isValid(password));

        // valid
        password = "Passw0rd!";
        assertTrue(validator.isValid(password));
    }

    /**
     * chain checks if:
     *      string's length > 8
     *      string contains at least 1 number
     *      string contains at least 1 uppercase letter
     *      string contains at least 1 non-alphanumeric character
     *
     * @return validation chain
     */
    private Validator<String> createValidator(){
        Validator<String> lengthValidator = new LengthValidator(8);
        Validator<String> numberValidator = new ContainsNumberValidator();
        Validator<String> uppercaseValidator = new ContainsUppercaseValidator();
        Validator<String> alphaNumValidator = new ContainsNonAlphaNumericValidator();

        lengthValidator.setNext(numberValidator);
        numberValidator.setNext(uppercaseValidator);
        uppercaseValidator.setNext(alphaNumValidator);

        return lengthValidator;
    }
}
