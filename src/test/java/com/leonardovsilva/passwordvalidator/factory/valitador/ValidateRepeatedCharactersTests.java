package com.leonardovsilva.passwordvalidator.factory.valitador;

import com.leonardovsilva.passwordvalidator.domain.Password;
import com.leonardovsilva.passwordvalidator.domain.validator.ValidateRepeatedCharacters;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ValidateRepeatedCharactersTests {

    @Test
    public void TestValidateRepeatedCharactersTGivenInvalidPasswordShouldResultIsInvalid()
    {
        var password = new Password();
        password.setNewPassword("AABTPC!FOK");
        password.setValid(Boolean.TRUE);

        var passwordValidator = new ValidateRepeatedCharacters();

        var result = passwordValidator.validate(password);

        assertEquals(Boolean.FALSE, result.isValid());
    }

    @Test
    public void TestValidateRepeatedCharactersTGivenValidPasswordShouldResultIsValid()
    {
        var password = new Password();
        password.setNewPassword("AbTp9!fok");
        password.setValid(Boolean.TRUE);

        var passwordValidator = new ValidateRepeatedCharacters();

        var result = passwordValidator.validate(password);

        assertEquals(Boolean.TRUE, result.isValid());
    }
}
