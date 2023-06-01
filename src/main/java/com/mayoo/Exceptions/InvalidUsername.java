package com.mayoo.Exceptions;

import com.mayoo.openapi.model.CreateUser;

public class InvalidUsername extends CustomException {
    public InvalidUsername(CreateUser message) {
        super(String.format("%s %s est incorect", message.getFirstName(), message.getLastName()));
    }
}
