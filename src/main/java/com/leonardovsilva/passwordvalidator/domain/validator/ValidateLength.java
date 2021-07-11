package com.leonardovsilva.passwordvalidator.domain.validator;

import com.leonardovsilva.passwordvalidator.domain.Password;
import com.leonardovsilva.passwordvalidator.domain.PasswordRules;
import com.leonardovsilva.passwordvalidator.domain.PasswordValidator;
import com.leonardovsilva.passwordvalidator.domain.enums.PasswordValidatorTypes;
import org.springframework.util.Assert;

public class ValidateLength extends ValidateBase implements PasswordValidator {

    private int minLength;

    @Override
    public void setup(PasswordRules ruleSet)
    {
        Assert.notNull(ruleSet, "Rule set cannot be null");

        minLength = ruleSet.getMinLength();
    }

    public Password validate(Password value)
    {
        Assert.notNull(value,"Password cannot be null");

        if (!value.isValid())
        {
            return value;
        }

        value.setValid(value.getNewPassword().length() >= minLength);

        if (!value.isValid())
        {
            value.setReason(getType());
        }
        return value;
    }

    public PasswordValidatorTypes getType() {
        return PasswordValidatorTypes.MIN_LENGTH;
    }


}
