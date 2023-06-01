package com.mayoo.Service.FieldUserCheck.Component;

import com.mayoo.Repository.UserRepository;
import com.mayoo.Service.FieldUserCheck.BaseComponent;
import com.mayoo.openapi.model.CreateUser;

public class ExistComponent extends BaseComponent<CreateUser> {
    
    private final UserRepository userRepository;
    
    public ExistComponent(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public void execute(CreateUser user) {
    }
}
