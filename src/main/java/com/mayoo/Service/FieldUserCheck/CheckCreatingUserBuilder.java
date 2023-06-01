package com.mayoo.Service.FieldUserCheck;

import com.mayoo.Repository.UserRepository;
import com.mayoo.Service.FieldUserCheck.Component.ExistComponent;
import com.mayoo.Service.FieldUserCheck.Component.MailComponent;
import com.mayoo.Service.FieldUserCheck.Component.UsernameComponent;
import com.mayoo.openapi.model.CreateUser;
import org.apache.catalina.User;

public class CheckCreatingUserBuilder {
    public static IComponentCheck<CreateUser> builderResponsabilityCheckCreatingUser(UserRepository userRepository) {
        IComponentCheck<CreateUser> checkExist = new ExistComponent(userRepository);
        IComponentCheck<CreateUser> checkEmail = new MailComponent();
        IComponentCheck<CreateUser> checkUsername = new UsernameComponent();
        IComponentCheck<CreateUser> checkPassword = new UsernameComponent();

        checkExist.setNext(checkEmail);
        checkEmail.setNext(checkUsername);
        checkUsername.setNext(checkPassword);

        return checkEmail;
    }
}