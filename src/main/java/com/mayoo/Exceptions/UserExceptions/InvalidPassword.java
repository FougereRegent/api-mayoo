package com.mayoo.Exceptions.UserExceptions;

import com.mayoo.Exceptions.CustomException;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.aspectj.bridge.Message;
import org.hibernate.query.sqm.tree.expression.SqmUnaryOperation;

public class InvalidPassword extends CustomException {
    public InvalidPassword(String message) {
        super(message);
    }
}
