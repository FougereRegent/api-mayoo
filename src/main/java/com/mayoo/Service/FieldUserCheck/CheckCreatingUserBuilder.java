package com.mayoo.Service.FieldUserCheck;

import com.mayoo.Repository.UserRepository;
import com.mayoo.Service.FieldUserCheck.Component.CreateUserComponent;
import com.mayoo.Service.FieldUserCheck.Component.ExistComponent;
import com.mayoo.Service.FieldUserCheck.Component.MailComponent;
import com.mayoo.Service.FieldUserCheck.Component.UsernameComponent;
import com.mayoo.openapi.model.CreateUser;

import java.util.Random;

public class CheckCreatingUserBuilder {
    public static IComponentCheck<CreateUser> builderResponsabilityCheckCreatingUser(UserRepository userRepository, Random random) {
        IComponentCheck<CreateUser> checkExist = new ExistComponent(userRepository);
        IComponentCheck<CreateUser> createUser = new CreateUserComponent(userRepository, random);
        IComponentCheck<CreateUser> checkEmail = new MailComponent();
        IComponentCheck<CreateUser> checkUsername = new UsernameComponent();
        IComponentCheck<CreateUser> checkPassword = new UsernameComponent();

        checkExist.setNext(checkEmail);
        checkEmail.setNext(checkUsername);
        checkUsername.setNext(checkPassword);
        checkPassword.setNext(createUser);

        return checkEmail;
    }
}
