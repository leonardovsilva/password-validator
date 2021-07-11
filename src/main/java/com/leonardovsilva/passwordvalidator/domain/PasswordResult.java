package com.leonardovsilva.passwordvalidator.domain;

import com.leonardovsilva.passwordvalidator.domain.enums.PasswordValidatorTypes;
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
