package com.leonardovsilva.passwordvalidator.factory.valitador;

import com.leonardovsilva.passwordvalidator.domain.Password;
import com.leonardovsilva.passwordvalidator.domain.PasswordRules;
import com.leonardovsilva.passwordvalidator.domain.validator.ValidateLength;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ValidateLengthTests {

    @Test
    public void TestValidateLengthGivenInvalidPasswordShouldResultIsInvalid()
    {
        var password = new Password();
        password.setNewPassword("AbTp");
        password.setValid(Boolean.TRUE);

        PasswordRules rules = PasswordRules.builder().minLength (9).build();

        var passwordValidator = new ValidateLength();
        passwordValidator.setup(rules);

        var result = passwordValidator.validate(password);

        assertEquals(Boolean.FALSE, result.isValid());
    }

    @Test
    public void TestValidateLengthGivenValidPasswordShouldResultIsValid()
    {
        var password = new Password();
        password.setNewPassword("AbTp9!fok");
        password.setValid(Boolean.TRUE);


        var passwordValidator = new ValidateLength();

        var result = passwordValidator.validate(password);

        assertEquals(Boolean.TRUE, result.isValid());
    }
}
