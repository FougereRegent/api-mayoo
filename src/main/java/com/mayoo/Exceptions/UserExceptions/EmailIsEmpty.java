package com.mayoo.Exceptions.UserExceptions;

import com.mayoo.Exceptions.CustomException;

public class EmailIsEmpty extends CustomException {
    public EmailIsEmpty() {
        super("L'email ne peux pas être vide");
    }
}
