package com.mayoo.Service.FieldUserCheck;

import com.mayoo.openapi.model.CreateUser;
public interface IComponentCheck {
    void setNext(IComponentCheck componentCheck);
    void execute(CreateUser user);
}
