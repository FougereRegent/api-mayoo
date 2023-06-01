package com.mayoo.Service.FieldUserCheck.Component;

import com.mayoo.Exceptions.CustomException;
import com.mayoo.Exceptions.EmailIsEmpty;
import com.mayoo.Exceptions.InvalidEmailFormat;
import com.mayoo.Service.FieldUserCheck.BaseComponent;
import com.mayoo.openapi.model.CreateUser;

import java.util.regex.*;

public class MailComponent extends BaseComponent<CreateUser> {
    private final String regex_email = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private final Pattern pattern = Pattern.compile(regex_email);
    @Override
    public void execute(CreateUser user) throws CustomException {
        String email = user.getEmail();
        Matcher m;

        if(email.isBlank() || email.isEmpty())
            throw new EmailIsEmpty();

        m = pattern.matcher(email);

        if(!m.find())
            throw new InvalidEmailFormat(email);

        this.nextHandle.execute(user);
    }
}
