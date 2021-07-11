package com.leonardovsilva.passwordvalidator.api.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class PasswordRequest {

    @NotBlank
    private String password;
}
