package com.mayoo.Service;

import com.mayoo.Exceptions.CustomException;

public interface IUserService {
    void createUser(com.mayoo.openapi.model.RegisterRequest user) throws CustomException;
    void logInUser(com.mayoo.openapi.model.RegisterRequest user);
}