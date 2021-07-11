package com.leonardovsilva.passwordvalidator.service;

import com.leonardovsilva.passwordvalidator.domain.enums.PasswordValidatorTypes;
import com.leonardovsilva.passwordvalidator.domain.PasswordResult;
import com.leonardovsilva.passwordvalidator.domain.Password;
import com.leonardovsilva.passwordvalidator.domain.PasswordRules;
import com.leonardovsilva.passwordvalidator.domain.PasswordValidator;
import com.leonardovsilva.passwordvalidator.domain.factory.ValidatorFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class PasswordServiceImpl implements PasswordService {

    private final ValidatorFactory validatorFactory;

    private ArrayList<PasswordValidator> validationSet;

    public PasswordServiceImpl(ValidatorFactory validatorFactory)
    {
        this.validatorFactory = validatorFactory;

        PasswordRules rules = PasswordRules.builder()
                .minLength(9)
                .SpecialChars(Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'))
                .build();

        setupRules(rules);
    }

    @Override
    public PasswordResult validatePassword(String passwordValue) {

        Password password = new Password();
        password.setNewPassword(passwordValue);
        password.setValid(true);
        password.setReason(PasswordValidatorTypes.NONE);

        for (var passwordValidation : validationSet)
        {
            password = passwordValidation.validate(password);
            if (!password.isValid())
            {
                break;
            }
        }

        return PasswordResult.toPasswordResult(password);
    }

    private void setupRules(PasswordRules ruleSet)
    {
        validationSet = validatorFactory.createValidationSet(ruleSet);
    }
}
