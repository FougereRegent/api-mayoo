package com.mayoo.Service;

import com.mayoo.Entity.UserEntity;
import com.mayoo.Exceptions.CustomException;
import org.apache.catalina.User;
import org.aspectj.weaver.loadtime.Options;

public interface IUserService {
    void createUser(com.mayoo.openapi.model.CreateUser user) throws CustomException;
    void logInUser(com.mayoo.openapi.model.LoginUser user);
}