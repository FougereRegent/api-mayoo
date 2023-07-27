package com.mayoo.Service;

import com.mayoo.Exceptions.CustomException;

public interface IUserService {
    com.mayoo.openapi.model.AuthenticationResponse createUser(com.mayoo.openapi.model.RegisterRequest user) throws CustomException;
    com.mayoo.openapi.model.AuthenticationResponse logInUser(com.mayoo.openapi.model.AuthenticationRequest user) throws CustomException;
    void setAllergenes(String jwtToken, com.mayoo.openapi.model.SetPictograms allergenes) throws CustomException;
        
}