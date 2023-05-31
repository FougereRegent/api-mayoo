package com.mayoo.Service.FieldUserCheck;

import com.mayoo.openapi.model.CreateUser;
public interface IComponentCheck<T> {
    void setNext(IComponentCheck<T> componentCheck);
    void execute(T user);
}
