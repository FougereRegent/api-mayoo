package com.mayoo.Exceptions.UserExceptions;

import com.mayoo.Exceptions.CustomException;

public class UsernameNotFoundException extends CustomException {
    public UsernameNotFoundException(String message) {
        super(message);
    }
}
