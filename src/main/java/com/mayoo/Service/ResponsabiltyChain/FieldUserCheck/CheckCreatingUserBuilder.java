package com.mayoo.Service.ResponsabiltyChain.FieldUserCheck;

import com.mayoo.Repository.UserRepository;
import com.mayoo.Service.ResponsabiltyChain.FieldUserCheck.Component.CreateUserComponent;
import com.mayoo.Service.ResponsabiltyChain.FieldUserCheck.Component.ExistComponent;
import com.mayoo.Service.ResponsabiltyChain.FieldUserCheck.Component.MailComponent;
import com.mayoo.Service.ResponsabiltyChain.FieldUserCheck.Component.UsernameComponent;
import com.mayoo.Service.ResponsabiltyChain.IComponentCheck;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Random;

public class CheckCreatingUserBuilder {
    public static IComponentCheck<com.mayoo.openapi.model.RegisterRequest> builderResponsabilityCheckCreatingUser(UserRepository userRepository, Random random, PasswordEncoder passwordEncoder) {
        IComponentCheck<com.mayoo.openapi.model.RegisterRequest> checkExist = new ExistComponent(userRepository);
        IComponentCheck<com.mayoo.openapi.model.RegisterRequest> createUser = new CreateUserComponent(userRepository, random, passwordEncoder);
        IComponentCheck<com.mayoo.openapi.model.RegisterRequest> checkEmail = new MailComponent();
        IComponentCheck<com.mayoo.openapi.model.RegisterRequest> checkUsername = new UsernameComponent();
        IComponentCheck<com.mayoo.openapi.model.RegisterRequest> checkPassword = new UsernameComponent();

        checkExist.setNext(checkEmail);
        checkEmail.setNext(checkUsername);
        checkUsername.setNext(checkPassword);
        checkPassword.setNext(createUser);

        return checkExist;
    }
}
