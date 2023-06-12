package com.mayoo.Service.ResponsabiltyChain;

import com.mayoo.Exceptions.CustomException;

public abstract class BaseComponent<T> implements IComponentCheck<T> {

    protected IComponentCheck<T> nextHandle;
    @Override
    public void setNext(IComponentCheck<T> componentCheck) {
        this.nextHandle = componentCheck;
    }

    @Override
    public abstract void execute(T user) throws CustomException;
}
