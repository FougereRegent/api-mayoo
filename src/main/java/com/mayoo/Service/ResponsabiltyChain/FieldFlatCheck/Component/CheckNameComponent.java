package com.mayoo.Service.ResponsabiltyChain.FieldFlatCheck.Component;

import com.mayoo.Exceptions.CustomException;
import com.mayoo.Exceptions.FlatExceptions.FlatNameIncorect;
import com.mayoo.Service.ResponsabiltyChain.BaseComponent;
import com.mayoo.openapi.model.Flat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckNameComponent extends BaseComponent<com.mayoo.openapi.model.Flat> {
    private static final String regex = "";
    @Override
    public void execute(Flat user) throws CustomException {
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(user.getName());
        
        if(!matcher.matches())
            throw new FlatNameIncorect(); 
        
       if(nextHandle != null)
           nextHandle.execute(user);
    }
}
