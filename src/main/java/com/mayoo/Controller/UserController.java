package com.mayoo.Controller;

import com.mayoo.Exceptions.CustomException;
import com.mayoo.Service.IUserService;
import com.mayoo.openapi.api.UserApi;
import com.mayoo.openapi.model.CreateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {
    private final IUserService userService;
    
    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }   

    @Override
    public ResponseEntity<Void> userAuthPost(Object body) {
        return UserApi.super.userAuthPost(body);
    }

    @Override
    public ResponseEntity<Void> userIdRightCreatePost(String idRight, CreateUser createUser) {
        ResponseEntity responseEntity;
        try {
            userService.createUser(createUser);
            responseEntity = new ResponseEntity(HttpStatus.CREATED);
        }
        catch (CustomException exception) {
            responseEntity = new ResponseEntity(HttpStatus.FORBIDDEN);
        }
        
        return responseEntity;
    }
}
