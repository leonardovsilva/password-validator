package com.leonardovsilva.passwordvalidator.domain.validator;

import com.leonardovsilva.passwordvalidator.domain.enums.PasswordValidatorTypes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Password {

    private String newPassword;

    private boolean valid;

    private PasswordValidatorTypes reason;
}
