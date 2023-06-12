package com.mayoo.Service.ResponsabiltyChain.FieldUserCheck.Component;

import com.mayoo.Exceptions.CustomException;
import com.mayoo.Exceptions.EmailIsEmpty;
import com.mayoo.Exceptions.InvalidEmailFormat;
import com.mayoo.Service.ResponsabiltyChain.BaseComponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailComponent extends BaseComponent<com.mayoo.openapi.model.RegisterRequest> {
    private final String regex_email = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private final Pattern pattern = Pattern.compile(regex_email);
    @Override
    public void execute(com.mayoo.openapi.model.RegisterRequest user) throws CustomException {
        String email = user.getEmail();
        Matcher m;

        if(email.isBlank() || email.isEmpty())
            throw new EmailIsEmpty();

        m = pattern.matcher(email);

        if(!m.find())
            throw new InvalidEmailFormat(email);

        if(this.nextHandle != null)
            this.nextHandle.execute(user);
    }
}