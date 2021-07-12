package com.leonardovsilva.passwordvalidator.factory.valitador;

import com.leonardovsilva.passwordvalidator.domain.Password;
import com.leonardovsilva.passwordvalidator.domain.PasswordRules;
import com.leonardovsilva.passwordvalidator.domain.validator.ValidateSpecialCharacter;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ValidateSpecialCharacterTests {

    @Test
    public void TestValidateSpecialCharacterTGivenInvalidPasswordShouldResultIsInvalid()
    {
        var password = new Password();
        password.setNewPassword("AABTPCFOK");
        password.setValid(Boolean.TRUE);

        PasswordRules rules = PasswordRules.builder().SpecialChars(Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+')).build();
        var passwordValidator = new ValidateSpecialCharacter();
        passwordValidator.setup(rules);

        var result = passwordValidator.validate(password);

        assertEquals(Boolean.FALSE, result.isValid());
    }

    @Test
    public void TestValidateSpecialCharacterTGivenValidPasswordShouldResultIsValid()
    {
        var password = new Password();
        password.setNewPassword("AbTp9!fok");
        password.setValid(Boolean.TRUE);

        PasswordRules rules = PasswordRules.builder().SpecialChars(Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+')).build();
        var passwordValidator = new ValidateSpecialCharacter();
        passwordValidator.setup(rules);

        var result = passwordValidator.validate(password);

        assertEquals(Boolean.TRUE, result.isValid());
    }
}
