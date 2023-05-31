package com.mayoo.Service;

import com.mayoo.Repository.UserRepository;
import com.mayoo.openapi.model.CreateUser;
import com.mayoo.openapi.model.LoginUser;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(CreateUser user) {

    }

    @Override
    public void logInUser(LoginUser user) {

    }
}
