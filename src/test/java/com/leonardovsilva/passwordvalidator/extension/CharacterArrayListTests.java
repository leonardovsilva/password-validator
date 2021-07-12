package com.leonardovsilva.passwordvalidator.extension;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CharacterArrayListTests {

    @Test
    public void TestCharacterArrayListConcat()
    {
        CharacterArrayList array = new CharacterArrayList();
        array.add('a');
        array.add('c');
        array.add('d');
        array.add('e');
        array.add('1');
        array.add('2');
        array.add('3');
        array.add('@');

        var result = array.concat();

        assertEquals(result, "acde123@");
    }
}
