package com.mayoo.DTO;

import com.mayoo.Entity.UserEntity;
import com.mayoo.openapi.model.CreateUser;

public class UserMapper {
    public static UserEntity CreateUserEntityToUserObject(CreateUser user) {
        UserEntity result = UserEntity.builder()
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .build();
        return result;
    }
}
