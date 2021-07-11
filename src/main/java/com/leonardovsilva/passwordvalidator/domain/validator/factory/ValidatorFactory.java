package com.leonardovsilva.passwordvalidator.domain.validator.factory;

import com.leonardovsilva.passwordvalidator.domain.validator.PasswordValidator;
import com.leonardovsilva.passwordvalidator.domain.validator.PasswordRules;

import java.util.ArrayList;

public interface ValidatorFactory {

    ArrayList<PasswordValidator> createValidationSet(PasswordRules ruleSet);
}
