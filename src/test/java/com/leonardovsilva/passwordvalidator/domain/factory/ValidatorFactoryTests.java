package com.leonardovsilva.passwordvalidator.domain.factory;

import com.leonardovsilva.passwordvalidator.domain.PasswordRules;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ValidatorFactoryTests {

    @Test
    public void TestCreateValidationSet()
    {
        var validTestRules = PasswordRules.builder()
                .minLength(9)
                .SpecialChars(Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+')).build();

        var factory = new ValidatorFactoryImpl();

        var valSet = factory.createValidationSet(validTestRules);

        assertEquals(6, valSet.size());
    }
}
