package com.mayoo.Service.FieldUserCheck.Component;

import com.mayoo.DTO.UserMapper;
import com.mayoo.Entity.UserEntity;
import com.mayoo.Exceptions.CustomException;
import com.mayoo.Repository.UserRepository;
import com.mayoo.Service.FieldUserCheck.BaseComponent;
import com.mayoo.openapi.model.CreateUser;
import org.apache.catalina.User;
import org.aspectj.apache.bcel.Constants;
import org.aspectj.apache.bcel.generic.FieldOrMethod;
import springfox.documentation.service.ApiListing;

import java.util.Random;

public class CreateUserComponent extends BaseComponent<CreateUser> {
    private final UserRepository userRepository;
    private final Random random;
    public CreateUserComponent(UserRepository userRepository, Random random) {
        this.userRepository = userRepository;
        this.random = random;
    }
    @Override
    public void execute(CreateUser user) throws CustomException {
        UserEntity userEntity = UserMapper.CreateUserEntityToUserObject(user);

        if(this.nextHandle != null)
            this.nextHandle.execute(user);
    }
    
    private String generateSalt(int size) {
        StringBuilder result = new StringBuilder();
        final int ascii_a = 97;
        final int ascii_z = 122;
        for(int index = 0; index < size; index++) {
            int generatedNumber = random.nextInt(ascii_a, ascii_z + 1);
            char c = (char)generatedNumber;
            result.append(c);
        }
        return result.toString();
    }
    
    private String createHash(String chaine) {
        return "";
    }
}
