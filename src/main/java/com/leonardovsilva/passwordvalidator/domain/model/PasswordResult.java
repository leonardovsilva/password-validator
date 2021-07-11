package com.leonardovsilva.passwordvalidator.domain.model;

import com.leonardovsilva.passwordvalidator.domain.enums.PasswordValidatorTypes;
import com.leonardovsilva.passwordvalidator.domain.validator.Password;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PasswordResult {

    private boolean valid;

    private PasswordValidatorTypes reason;

    public static PasswordResult toPasswordResult(Password password){
        return PasswordResult.builder().valid(password.isValid()).reason(password.getReason()).build();
    }
}
