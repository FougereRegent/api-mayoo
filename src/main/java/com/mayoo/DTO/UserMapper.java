package com.mayoo.DTO;

import com.mayoo.Entity.UserEntity;

public class UserMapper {
    public static UserEntity CreateUserEntityToUserObject(com.mayoo.openapi.model.RegisterRequest user) {
        UserEntity result = UserEntity.builder()
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .build();
        return result;
    }
}
