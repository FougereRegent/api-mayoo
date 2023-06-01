package com.mayoo.Exceptions;

public class EmptyUsername extends CustomException {
    public EmptyUsername() {
        super("Les prénom et les noms sont vides");
    }
}
