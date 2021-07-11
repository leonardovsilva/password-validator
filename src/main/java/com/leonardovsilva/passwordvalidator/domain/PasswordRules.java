package com.leonardovsilva.passwordvalidator.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class PasswordRules {

    /**
     * Min allowed password length
     */
    private int minLength;

    /**
     * Special characters allowed
     */
    private List<Character> SpecialChars;
}
