package com.mayoo.Service.ResponsabiltyChain.FieldUserCheck.Component;

import com.mayoo.Exceptions.CustomException;
import com.mayoo.Exceptions.EmptyUsername;
import com.mayoo.Service.ResponsabiltyChain.BaseComponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsernameComponent extends BaseComponent<com.mayoo.openapi.model.RegisterRequest> {
    private final String regex_name_and_lastname = "\\b([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+";
    private final Pattern pattern = Pattern.compile(regex_name_and_lastname);
    @Override
    public void execute(com.mayoo.openapi.model.RegisterRequest user) throws CustomException {
        String first_name = user.getFirstName();
        String last_name = user.getLastName();
        Matcher mfirst_name = pattern.matcher(first_name);
        Matcher mlast_name = pattern.matcher(last_name);

        if(first_name.isEmpty() || last_name.isEmpty()) throw new EmptyUsername();
        //if((mfirst_name.find() && mlast_name.find())) throw new InvalidUsername(user);

        if(this.nextHandle != null)
            this.nextHandle.execute(user);
    }
}
