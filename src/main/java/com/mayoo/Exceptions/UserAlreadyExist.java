package com.mayoo.Exceptions;

import com.mayoo.openapi.model.CreateUser;
public class UserAlreadyExist extends  CustomException{
    public UserAlreadyExist(CreateUser createUser) {
        super(String.format("%s %s existe déja", createUser.getFirstName(), createUser.getLastName()));
    }
}
