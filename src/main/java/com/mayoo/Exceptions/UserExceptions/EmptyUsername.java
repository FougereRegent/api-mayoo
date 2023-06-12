package com.mayoo.Exceptions.UserExceptions;

import com.mayoo.Exceptions.CustomException;

public class EmptyUsername extends CustomException {
    public EmptyUsername() {
        super("Les prénom et les noms sont vides");
    }
}
