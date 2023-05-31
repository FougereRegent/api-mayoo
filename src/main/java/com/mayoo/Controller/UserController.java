package com.mayoo.Controller;

import com.mayoo.openapi.api.UserApi;
import com.mayoo.openapi.model.CreateUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {

    @Override
    public ResponseEntity<Void> userAuthPost(Object body) {
        return UserApi.super.userAuthPost(body);
    }

    @Override
    public ResponseEntity<Void> userIdRightCreatePost(String idRight, CreateUser createUser) {
        return new ResponseEntity(idRight, HttpStatus.OK);
    }
}
