package com.leonardovsilva.passwordvalidator.factory.valitador;

import com.leonardovsilva.passwordvalidator.domain.Password;
import com.leonardovsilva.passwordvalidator.domain.validator.ValidateLowercase;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ValidateLowercaseTests {

    @Test
    public void TestValidateLowercaseTGivenInvalidPasswordShouldResultIsInvalid()
    {
        var password = new Password();
        password.setNewPassword("ABTPC!FOK");
        password.setValid(Boolean.TRUE);

        var passwordValidator = new ValidateLowercase();

        var result = passwordValidator.validate(password);

        assertEquals(Boolean.FALSE, result.isValid());
    }

    @Test
    public void TestValidateLowercaseTGivenValidPasswordShouldResultIsValid()
    {
        var password = new Password();
        password.setNewPassword("AbTp9!fok");
        password.setValid(Boolean.TRUE);

        var passwordValidator = new ValidateLowercase();

        var result = passwordValidator.validate(password);

        assertEquals(Boolean.TRUE, result.isValid());
    }
}
