package com.leonardovsilva.passwordvalidator.factory.valitador;

import com.leonardovsilva.passwordvalidator.domain.Password;
import com.leonardovsilva.passwordvalidator.domain.validator.ValidateUpperCase;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ValidateUpperCaseTests {

    @Test
    public void TestValidateUpperCaseTGivenInvalidPasswordShouldResultIsInvalid()
    {
        var password = new Password();
        password.setNewPassword("abtpc!fok");
        password.setValid(Boolean.TRUE);

        var passwordValidator = new ValidateUpperCase();

        var result = passwordValidator.validate(password);

        assertEquals(Boolean.FALSE, result.isValid());
    }

    @Test
    public void TestValidateUpperCaseTGivenValidPasswordShouldResultIsValid()
    {
        var password = new Password();
        password.setNewPassword("AbTp9!fok");
        password.setValid(Boolean.TRUE);


        var passwordValidator = new ValidateUpperCase();

        var result = passwordValidator.validate(password);

        assertEquals(Boolean.TRUE, result.isValid());
    }
}
