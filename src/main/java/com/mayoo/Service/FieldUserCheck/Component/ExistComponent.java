package com.mayoo.Service.FieldUserCheck.Component;

import com.mayoo.Entity.UserEntity;
import com.mayoo.Exceptions.CustomException;
import com.mayoo.Exceptions.UserAlreadyExist;
import com.mayoo.Repository.UserRepository;
import com.mayoo.Service.FieldUserCheck.BaseComponent;
import com.mayoo.openapi.model.CreateUser;

import java.util.Optional;

public class ExistComponent extends BaseComponent<CreateUser> {
    
    private final UserRepository userRepository;
    
    public ExistComponent(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public void execute(CreateUser user) throws CustomException {
        Optional<UserEntity> opuser = this.userRepository.findUserEntityByEmail(user.getEmail());
        if(opuser.isPresent())
            throw new UserAlreadyExist(user);
        if(this.nextHandle != null)
            this.nextHandle.execute(user);
    }
}
