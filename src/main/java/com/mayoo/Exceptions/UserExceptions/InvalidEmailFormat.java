package com.mayoo.Exceptions.UserExceptions;

import com.mayoo.Exceptions.CustomException;

public class InvalidEmailFormat extends CustomException {
    public InvalidEmailFormat(String mail) {
        super(String.format("%s mauvais format de mail", mail));
    }
}
