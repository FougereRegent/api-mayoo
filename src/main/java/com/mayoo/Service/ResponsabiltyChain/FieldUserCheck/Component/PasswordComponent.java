package com.mayoo.Service.ResponsabiltyChain.FieldUserCheck.Component;

import com.mayoo.Exceptions.CustomException;
import com.mayoo.Exceptions.UserExceptions.InvalidPassword;
import com.mayoo.Service.ResponsabiltyChain.BaseComponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordComponent extends BaseComponent<com.mayoo.openapi.model.RegisterRequest> {

    private final String regex_password = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
    private final Pattern pattern = Pattern.compile(regex_password);

    @Override
    public void execute(com.mayoo.openapi.model.RegisterRequest user) throws CustomException {
        String password = user.getPassword();
        String validpassword = user.getValidPassword();

        if(password.isEmpty() || validpassword.isEmpty())
            throw new InvalidPassword("mot de passe vide");
        if(!checkPassword(password))
            throw new InvalidPassword("Le mot de passe ne correspond pas au critère de création de mot de passe");
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
