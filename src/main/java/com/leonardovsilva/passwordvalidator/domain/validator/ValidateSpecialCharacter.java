package com.leonardovsilva.passwordvalidator.domain.validator;

import com.leonardovsilva.passwordvalidator.domain.Password;
import com.leonardovsilva.passwordvalidator.domain.PasswordRules;
import com.leonardovsilva.passwordvalidator.domain.PasswordValidator;
import com.leonardovsilva.passwordvalidator.domain.enums.PasswordValidatorTypes;
import com.leonardovsilva.passwordvalidator.extension.CharacterArrayList;
import org.springframework.util.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateSpecialCharacter extends ValidateBase implements PasswordValidator {

    private Pattern pattern;
    private final CharacterArrayList charSet;

    public ValidateSpecialCharacter()
    {
        charSet = new CharacterArrayList();
    }

    @Override
    public void setup(PasswordRules ruleSet)
    {
        Assert.notNull(ruleSet, "Rule set cannot be null");

        charSet.addAll(ruleSet.getSpecialChars());
        var set = charSet.concat();
        pattern = Pattern.compile("(.*["+set+"])");
    }

    public Password validate(Password value)
    {
        Assert.notNull(value,"Password cannot be null");

        if (!value.isValid())
        {
            return value;
        }

        Matcher regexMatcher = pattern.matcher(value.getNewPassword());

        value.setValid(regexMatcher.find());

        if (!value.isValid())
        {
            value.setReason(getType());
        }
        return value;
    }

    public PasswordValidatorTypes getType() {
        return PasswordValidatorTypes.SPECIAL_CHARACTER;
    }
}
