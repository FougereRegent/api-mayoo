package com.mayoo.Service.ResponsabiltyChain.FieldUserCheck.Component;

import com.mayoo.Exceptions.CustomException;

public class InvalidUserCredentials extends CustomException {
    private static final String message_exception = "Utilisateur/mot de passe incorrect";
    public InvalidUserCredentials() {
        super(message_exception);
    }
}
