package com.mayoo.Service;

import com.mayoo.Exceptions.CustomException;
import com.mayoo.Repository.UserRepository;
import com.mayoo.Service.FieldUserCheck.CheckCreatingUserBuilder;
import com.mayoo.Service.FieldUserCheck.IComponentCheck;
import com.mayoo.openapi.model.CreateUser;
import com.mayoo.openapi.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserService implements IUserService{

    private final UserRepository userRepository;
    private final IComponentCheck<CreateUser> componentCheckCreateUser;
    private final Random random;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.random = new Random();
        this.componentCheckCreateUser = CheckCreatingUserBuilder.builderResponsabilityCheckCreatingUser(userRepository, random);
    }

    @Override
    public void createUser(CreateUser user) throws CustomException {
        try {
            this.componentCheckCreateUser.execute(user);
        }
        catch (CustomException exception)
        {
            throw exception;
        }
    }

    @Override
    public void logInUser(LoginUser user) {

    }
}
