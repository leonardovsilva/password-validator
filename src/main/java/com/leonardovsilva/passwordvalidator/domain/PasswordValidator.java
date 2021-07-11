package com.leonardovsilva.passwordvalidator.domain;

import com.leonardovsilva.passwordvalidator.domain.Password;
import com.leonardovsilva.passwordvalidator.domain.PasswordRules;
import com.leonardovsilva.passwordvalidator.domain.enums.PasswordValidatorTypes;

public interface PasswordValidator {

    /***
     * Validates Password
     * @param value IPassword to validate
     * @return Password
     */
    Password validate(Password value);

    /**
     * Gets the type of Validator
     * @return PasswordValidatorTypes
     */
    PasswordValidatorTypes getType();

    /**
     * Sets up the validator according to the rule set.
     * @param ruleSet The rule set to apply
     */
    void setup(PasswordRules ruleSet);

}
