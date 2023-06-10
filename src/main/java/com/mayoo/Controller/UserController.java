package com.mayoo.Controller;

import com.mayoo.Exceptions.CustomException;
import com.mayoo.Service.IUserService;
import com.mayoo.openapi.api.AuthApi;
import com.mayoo.openapi.model.AuthenticationRequest;
import com.mayoo.openapi.model.AuthenticationResponse;
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
        return AuthApi.super.authUserPost(authenticationRequest);
    }
}
