package com.leonardovsilva.passwordvalidator.domain.factory;

import com.leonardovsilva.passwordvalidator.domain.PasswordRules;
import com.leonardovsilva.passwordvalidator.domain.PasswordValidator;
import com.leonardovsilva.passwordvalidator.domain.validator.*;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class ValidatorFactoryImpl implements ValidatorFactory {

    private static final ArrayList<PasswordValidator> validators = new ArrayList<>();

    public ValidatorFactoryImpl() {

        validators.addAll(Arrays.asList(
                new ValidateDigit(),
                new ValidateLowercase(),
                new ValidateUpperCase(),
                new ValidateRepeatedCharacters(),
                new ValidateSpecialCharacter(),
                new ValidateLength()));
    }


    public ArrayList<PasswordValidator> createValidationSet(PasswordRules ruleSet)
    {
        Assert.notNull(ruleSet, "Rule set cannot be null");

        var result = new ArrayList<PasswordValidator>();

        for (var validator : validators)
        {
            validator.setup(ruleSet);
            result.add(validator);
        }

        return result;
    }
}
