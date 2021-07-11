package com.leonardovsilva.passwordvalidator.domain.validator;

import com.leonardovsilva.passwordvalidator.domain.enums.PasswordValidatorTypes;
import org.springframework.util.Assert;

import java.util.regex.Pattern;

public class ValidateDigit extends ValidateBase implements PasswordValidator {

    private final Pattern pattern;

    public ValidateDigit()
    {
        pattern = Pattern.compile(".*\\d.*");
    }

    public Password validate(Password value)
    {
        Assert.notNull(value,"Password cannot be null");

        if (!value.isValid())
        {
            return value;
        }

        boolean regexMatcher = pattern.matcher(value.getNewPassword()).matches();

        value.setValid(regexMatcher);

        if (!value.isValid())
        {
            value.setReason(getType());
        }
        return value;
    }

    public PasswordValidatorTypes getType() {
        return PasswordValidatorTypes.DIGIT;
    }
}