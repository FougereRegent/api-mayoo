package com.mayoo.Service.FieldUserCheck.Component;

import com.mayoo.DTO.UserMapper;
import com.mayoo.Entity.UserEntity;
import com.mayoo.Exceptions.CustomException;
import com.mayoo.Repository.UserRepository;
import com.mayoo.Service.FieldUserCheck.BaseComponent;
import org.springframework.util.DigestUtils;

import java.util.Random;

public class CreateUserComponent extends BaseComponent<com.mayoo.openapi.model.RegisterRequest> {
    private final UserRepository userRepository;
    private final Random random;
    public CreateUserComponent(UserRepository userRepository, Random random) {
        this.userRepository = userRepository;
        this.random = random;
    }
    @Override
    public void execute(com.mayoo.openapi.model.RegisterRequest user) throws CustomException {
        final int salt_size = 10;
        UserEntity userEntity = UserMapper.CreateUserEntityToUserObject(user);
        String salt = generateSalt(salt_size);
        String password = String.format("%s%s", salt, user.getPassword());
        password = createHash(password);
        
        userEntity.setSalt(salt);
        userEntity.setPassword(password);
        
        userRepository.save(userEntity);

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
        String digest = DigestUtils.md5DigestAsHex(chaine.getBytes());
        return digest;
    }
}
