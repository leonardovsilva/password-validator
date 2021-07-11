package com.leonardovsilva.passwordvalidator.api.output;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.leonardovsilva.passwordvalidator.domain.enums.PasswordValidatorTypes;
import com.leonardovsilva.passwordvalidator.domain.model.PasswordResult;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PasswordResponse {

    private boolean valid;

    private String reason;

    public boolean isValid() {
        return valid;
    }

    public String getReason() {
        return reason;
    }

    public PasswordResponse toPasswordResponse(PasswordResult result){
        this.valid = result.isValid();

        if(result.getReason() != PasswordValidatorTypes.NONE){
            this.reason = result.getReason().toString();
        }

        return  this;
    }
}
