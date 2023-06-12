package com.mayoo.Exceptions.FlatExceptions;

import com.mayoo.Exceptions.CustomException;

public class FlatAlreadyExist extends CustomException {
    private static final String message = "Le plat exist déjà impossible d'en créer un second";
    public FlatAlreadyExist() {
        super(message);
    }
}
