package com.mayoo.Service.FieldUserCheck;

import com.mayoo.Service.FieldUserCheck.IComponentCheck;
import com.mayoo.openapi.model.CreateUser;

public abstract class BaseComponent implements IComponentCheck {

    protected IComponentCheck nextHandle;
    @Override
    public void setNext(IComponentCheck componentCheck) {
        this.nextHandle = componentCheck;
    }
    @Override
    public abstract void execute(CreateUser user);
}
