package com.leonardovsilva.passwordvalidator.domain.validator;

import com.leonardovsilva.passwordvalidator.domain.enums.PasswordValidatorTypes;
import org.springframework.util.Assert;


public class ValidateRepeatedCharacters extends ValidateBase implements PasswordValidator {


    public Password validate(Password value)
    {
        Assert.notNull(value,"Password cannot be null");

        if (!value.isValid())
        {
            return value;
        };

        value.setValid(check(value.getNewPassword()));

        if (!value.isValid())
        {
            value.setReason(getType());
        }
        return value;
    }

    public static boolean check(CharSequence g) {
        for (int i = 0; i < g.length(); i++) {
            for (int j = i + 1; j < g.length(); j++) {
                if (g.charAt(i) == g.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public PasswordValidatorTypes getType() {
        return PasswordValidatorTypes.REPEATED_CHARACTERS;
    }
}
