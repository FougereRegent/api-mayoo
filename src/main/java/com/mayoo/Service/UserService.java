package com.mayoo.Service;

import com.mayoo.Entity.UserEntity;
import com.mayoo.Exceptions.CustomException;
import com.mayoo.Repository.UserRepository;
import com.mayoo.Service.FieldUserCheck.CheckCreatingUserBuilder;
import com.mayoo.Service.FieldUserCheck.Component.InvalidUserCredentials;
import com.mayoo.Service.FieldUserCheck.IComponentCheck;
import com.mayoo.openapi.model.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Random;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final IComponentCheck<com.mayoo.openapi.model.RegisterRequest> componentCheckCreateUser;
    private final IJwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final Random random;

    @Autowired
    public UserService(UserRepository userRepository, IJwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.random = new Random();
        this.componentCheckCreateUser = CheckCreatingUserBuilder.builderResponsabilityCheckCreatingUser(userRepository, random);
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public AuthenticationResponse createUser(com.mayoo.openapi.model.RegisterRequest user) throws CustomException {
        try {
            this.componentCheckCreateUser.execute(user);
        }
        catch (CustomException exception)
        {
            throw exception;
        }
        UserEntity userEntity = userRepository.findUserEntityByEmail(user.getEmail())
                .orElseThrow();
        String jwtToken = jwtService.generateToken(userEntity);
        AuthenticationResponse response = new AuthenticationResponse();
        response.token(jwtToken);
        return response;
    }

    @Override
    public com.mayoo.openapi.model.AuthenticationResponse logInUser(com.mayoo.openapi.model.AuthenticationRequest user) throws CustomException{
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getEmail(),
                        user.getPassword()
                )
        );
        UserEntity userEntity = userRepository.findUserEntityByEmail(user.getEmail())
                .orElseThrow();
        
        if(!checkPasswordIsSame(userEntity, user))
            throw new InvalidUserCredentials();
        
        String jwtToken = jwtService.generateToken(userEntity);
        com.mayoo.openapi.model.AuthenticationResponse response = new AuthenticationResponse();
        response.token(jwtToken);
        return response;
    }
    
    private boolean checkPasswordIsSame(UserEntity user, com.mayoo.openapi.model.AuthenticationRequest userRequest) {
        final String passwordDb  = user.getPassword();
        final String saltDb = user.getSalt();
        
        String password = String.format("%s%s", saltDb, userRequest.getPassword());
        String digest = DigestUtils.md5DigestAsHex(password.getBytes());

        return passwordDb.equals(digest);
    }
}
