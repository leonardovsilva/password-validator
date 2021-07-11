package com.leonardovsilva.passwordvalidator.extension;

import java.util.ArrayList;

public class CharacterArrayList extends ArrayList<Character> {

    public String concat()
    {
        StringBuilder builder = new StringBuilder(size());
        for(Character ch: this)
        {
            builder.append(ch);
        }
        return builder.toString();
    }
}
