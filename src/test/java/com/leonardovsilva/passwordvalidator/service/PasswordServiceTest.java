package com.leonardovsilva.passwordvalidator.service;

import com.leonardovsilva.passwordvalidator.domain.factory.ValidatorFactory;
import com.leonardovsilva.passwordvalidator.domain.factory.ValidatorFactoryImpl;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;

@SpringBootTest
@RunWith(value = Parameterized.class)
public class PasswordServiceTest {

    private final PasswordService passwordService;

    private final  String password;
    private final boolean expected;


    public PasswordServiceTest(String password, boolean expected) {
        this.password = password;
        this.expected = expected;

        ValidatorFactory validatorFactory = new ValidatorFactoryImpl();
        this.passwordService = new PasswordServiceImpl(validatorFactory);
    }

    @Parameterized.Parameters(name= "{index}: validatePassword({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"", false},
                {"aa", false},
                {"ab", false},
                {"AAAbbbCc", false},
                {"AbTp9!foo", false},
                {"AbTp9!foA", false},
                {"AbTp9 fok", false},
                {"AbTp9!fok", true}
        });
    }
    @Test
    public void testPasswordServiceParameterized() {
        var result= passwordService.validatePassword(password);
        MatcherAssert.assertThat(result.isValid(), is(equalTo(expected)));
    }
}
