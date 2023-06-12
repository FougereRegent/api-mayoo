package com.mayoo.Exceptions.FlatExceptions;

import com.mayoo.Exceptions.CustomException;

public class FlatNameIncorect extends CustomException {
    private static final String message = "Le nom du plat est incorect";
    public FlatNameIncorect() {
        super(message);
    }
}
