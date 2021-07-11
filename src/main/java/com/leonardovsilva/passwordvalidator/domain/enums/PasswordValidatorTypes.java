package com.leonardovsilva.passwordvalidator.domain.enums;

public enum PasswordValidatorTypes {

    NONE(0), DIGIT(1), LOWERCASE_LETTER(2), UPPERCASE_LETTER(3), SPECIAL_CHARACTER(4),
    REPEATED_CHARACTERS(5), MIN_LENGTH(6);

    private final int value;

    PasswordValidatorTypes(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public boolean Compare(int i){return value == i;}

    public static PasswordValidatorTypes GetValue(int value)
    {
        PasswordValidatorTypes[] As = PasswordValidatorTypes.values();
        for(int i = 0; i < As.length; i++)
        {
            if(As[i].Compare(value))
                return As[i];
        }
        return null;
    }
}
