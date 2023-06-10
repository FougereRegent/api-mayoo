package com.mayoo.Controller;

import com.mayoo.Exceptions.CustomException;
import com.mayoo.Service.IUserService;
import com.mayoo.openapi.api.AuthApi;
import com.mayoo.openapi.model.AuthenticationRequest;
import com.mayoo.openapi.model.AuthenticationResponse;
import com.mayoo.openapi.model.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements com.mayoo.openapi.api.AuthApi {
    private final IUserService userService;
    
    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<Void> authUserIdRightCreatePost(String idRight, RegisterRequest registerRequest) {
        ResponseEntity responseEntity;
        try {
            userService.createUser(registerRequest);
            responseEntity = new ResponseEntity(HttpStatus.CREATED);
        } catch (CustomException exception) {
            responseEntity = new ResponseEntity(HttpStatus.FORBIDDEN);
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<AuthenticationResponse> authUserPost(AuthenticationRequest authenticationRequest) {
        return AuthApi.super.authUserPost(authenticationRequest);
    }
}
