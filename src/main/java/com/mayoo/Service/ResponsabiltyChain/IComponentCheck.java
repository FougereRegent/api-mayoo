package com.mayoo.Service.ResponsabiltyChain;

import com.mayoo.Exceptions.CustomException;
public interface IComponentCheck<T> {
    void setNext(IComponentCheck<T> componentCheck);
    void execute(T user) throws CustomException;
}
