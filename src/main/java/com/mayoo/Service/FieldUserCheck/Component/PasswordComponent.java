package com.mayoo.Service.FieldUserCheck.Component;

import com.mayoo.Exceptions.CustomException;
import com.mayoo.Exceptions.InvalidPassword;
import com.mayoo.Exceptions.InvalidUsername;
import com.mayoo.Service.FieldUserCheck.BaseComponent;
import com.mayoo.openapi.model.CreateUser;

import java.util.regex.*;

public class PasswordComponent extends BaseComponent<CreateUser> {

    private final String regex_password = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
    private final Pattern pattern = Pattern.compile(regex_password);

    @Override
    public void execute(CreateUser user) throws CustomException {
        String password = user.getPassword();
        String validpassword = user.getValidPassword();

        if(password.isEmpty() || validpassword.isEmpty())
            throw new InvalidPassword("mot de passe vide");
        if(!checkPassword(password))
            throw new InvalidUsername("Le mot de passe ne correspond pas au critère de création de mot de passe");
        if(!password.equals(validpassword))
            throw new InvalidPassword("Le mot de passe n'est pas égal à la validation");
        if(this.nextHandle != null)
            this.nextHandle.execute(user);
    }

    private boolean checkPassword(String password) {
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
}
