package com.mayoo.DTO;

import com.mayoo.Entity.UserEntity;

public class UserMapper {
    public static UserEntity CreateUserEntityToUserObject(com.mayoo.openapi.model.RegisterRequest user) {
        UserEntity result = new UserEntity();
        result.setEmail(user.getEmail());
        result.setFirstName(user.getFirstName());
        result.setLastName(user.getLastName());
        result.setPassword(user.getPassword());
        return result;
    }
}
