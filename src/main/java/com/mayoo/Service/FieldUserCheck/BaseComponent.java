package com.mayoo.Service.FieldUserCheck;

import com.mayoo.Exceptions.CustomException;
import com.mayoo.Exceptions.UserAlreadyExist;

public abstract class BaseComponent<T> implements IComponentCheck<T> {

    protected IComponentCheck<T> nextHandle;
    @Override
    public void setNext(IComponentCheck<T> componentCheck) {
        this.nextHandle = componentCheck;
    }

    @Override
    public abstract void execute(T user) throws CustomException;
}
