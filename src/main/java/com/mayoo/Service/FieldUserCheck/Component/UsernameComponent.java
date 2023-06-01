package com.mayoo.Service.FieldUserCheck.Component;

import com.mayoo.Exceptions.CustomException;
import com.mayoo.Service.FieldUserCheck.BaseComponent;
import com.mayoo.openapi.model.CreateUser;

public class UsernameComponent extends BaseComponent<CreateUser> {
    @Override
    public void execute(CreateUser user) throws CustomException {

        if(this.nextHandle != null)
            this.nextHandle.execute(user);
    }
}
