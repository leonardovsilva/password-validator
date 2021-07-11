package com.leonardovsilva.passwordvalidator.domain.factory;

import com.leonardovsilva.passwordvalidator.domain.PasswordValidator;
import com.leonardovsilva.passwordvalidator.domain.PasswordRules;

import java.util.ArrayList;

public interface ValidatorFactory {

    ArrayList<PasswordValidator> createValidationSet(PasswordRules ruleSet);
}
