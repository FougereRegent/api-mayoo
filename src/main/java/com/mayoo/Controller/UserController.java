package com.mayoo.Controller;

import com.mayoo.Exceptions.CustomException;
import com.mayoo.Service.IUserService;
import com.mayoo.openapi.model.AuthenticationRequest;
import com.mayoo.openapi.model.AuthenticationResponse;
import com.mayoo.openapi.model.ErrorMessage;
import com.mayoo.openapi.model.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements com.mayoo.openapi.api.AuthApi {
    private final IUserService userService;

    @Override
    public ResponseEntity<AuthenticationResponse> authUserIdRightCreatePost(String idRight, RegisterRequest registerRequest) {
        ResponseEntity responseEntity;
        try {
            AuthenticationResponse response = userService.createUser(registerRequest);
            responseEntity = ResponseEntity.ok(response);
        } catch (CustomException exception) {
            responseEntity = new ResponseEntity(HttpStatus.FORBIDDEN);
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<AuthenticationResponse> authUserPost(AuthenticationRequest authenticationRequest) {
        ResponseEntity responseEntity;
        try {
            AuthenticationResponse response = userService.logInUser(authenticationRequest);
            responseEntity = ResponseEntity.ok(response);
        } catch (CustomException exception) {
            com.mayoo.openapi.model.ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.message(exception.getMessage());
            errorMessage.code(401);
            responseEntity = new ResponseEntity(errorMessage, HttpStatus.UNAUTHORIZED); 
        }
        return responseEntity;
    }
}