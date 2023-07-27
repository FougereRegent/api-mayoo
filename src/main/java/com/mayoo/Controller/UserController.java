package com.mayoo.Controller;

import com.mayoo.Exceptions.CustomException;
import com.mayoo.Service.IUserService;
import com.mayoo.openapi.model.SetPictograms;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements com.mayoo.openapi.api.AuthApi {
    private final IUserService userService;
    @Override
    public ResponseEntity<com.mayoo.openapi.model.AuthenticationResponse> authUserIdRightCreatePost(String idRight, com.mayoo.openapi.model.RegisterRequest registerRequest) {
        ResponseEntity responseEntity;
        try {
            com.mayoo.openapi.model.AuthenticationResponse response = userService.createUser(registerRequest);
            responseEntity = ResponseEntity.ok(response);
        } catch (CustomException exception) {
            responseEntity = new ResponseEntity(HttpStatus.FORBIDDEN);
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<com.mayoo.openapi.model.AuthenticationResponse> authUserPost(com.mayoo.openapi.model.AuthenticationRequest authenticationRequest) {
        ResponseEntity responseEntity;
        try {
            com.mayoo.openapi.model.AuthenticationResponse response = userService.logInUser(authenticationRequest);
            responseEntity = ResponseEntity.ok(response);
        } catch (CustomException exception) {
            com.mayoo.openapi.model.ErrorMessage errorMessage = new com.mayoo.openapi.model.ErrorMessage();
            errorMessage.message(exception.getMessage());
            errorMessage.code(401);
            responseEntity = new ResponseEntity(errorMessage, HttpStatus.UNAUTHORIZED); 
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<Void> authUserAllergenesPost(SetPictograms setPictograms, String authorization) {
        return  new ResponseEntity(authorization, HttpStatus.OK);
    }
}