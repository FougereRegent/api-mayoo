package com.mayoo.Service.FieldUserCheck.Component;

import com.mayoo.Exceptions.CustomException;
import com.mayoo.Repository.UserRepository;
import com.mayoo.Service.FieldUserCheck.BaseComponent;
import com.mayoo.openapi.model.CreateUser;
import org.apache.catalina.User;

import java.util.Random;

public class CreateUserComponent extends BaseComponent<CreateUser> {

    private final UserRepository userRepository;
    private final Random random;
    public CreateUserComponent(UserRepository userRepository, Random random) {
        this.userRepository = userRepository;
        this.random = random;
    }
    @Override
    public void execute(CreateUser user) throws CustomException {

        if(this.nextHandle != null)
            this.nextHandle.execute(user);
    }
}
