package com.mayoo.Exceptions;

public class InvalidEmailFormat extends CustomException {
    public InvalidEmailFormat(String mail) {
        super(String.format("%s mauvais format de mail", mail));
    }
}
