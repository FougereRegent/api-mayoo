package com.mayoo.Exceptions;

public class InvalidUsername extends CustomException {
    public InvalidUsername(com.mayoo.openapi.model.RegisterRequest message) {
        super(String.format("%s %s est incorect", message.getFirstName(), message.getLastName()));
    }
}
