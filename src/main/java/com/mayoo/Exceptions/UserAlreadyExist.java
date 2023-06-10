package com.mayoo.Exceptions;

public class UserAlreadyExist extends  CustomException{
    public UserAlreadyExist(com.mayoo.openapi.model.RegisterRequest createUser) {
        super(String.format("%s %s existe déja", createUser.getFirstName(), createUser.getLastName()));
    }
}
