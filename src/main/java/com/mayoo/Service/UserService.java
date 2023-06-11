package com.mayoo.Service;

import com.mayoo.Entity.UserEntity;
import com.mayoo.Exceptions.CustomException;
import com.mayoo.Repository.UserRepository;
import com.mayoo.Service.FieldUserCheck.CheckCreatingUserBuilder;
import com.mayoo.Service.FieldUserCheck.IComponentCheck;
import com.mayoo.openapi.model.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final IComponentCheck<com.mayoo.openapi.model.RegisterRequest> componentCheckCreateUser;
    private final IJwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final Random random;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, IJwtService jwtService, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.random = new Random();
        this.componentCheckCreateUser = CheckCreatingUserBuilder.builderResponsabilityCheckCreatingUser(userRepository, random, passwordEncoder);
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
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
        UserEntity userEntity = userRepository.findUserEntityByEmail(user.getEmail())
                .orElseThrow();
        
        String email = user.getEmail();
        String saltpassword = String.format("%s%s", userEntity.getSalt(), user.getPassword());
        
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        email,
                        saltpassword
                )
        );
        
        String jwtToken = jwtService.generateToken(userEntity);
        com.mayoo.openapi.model.AuthenticationResponse response = new AuthenticationResponse();
        response.token(jwtToken);
        return response;
    }
    
    private boolean checkPasswordIsSame(UserEntity user, com.mayoo.openapi.model.AuthenticationRequest userRequest) {
        final String passwordDb  = user.getPassword();
        final String saltDb = user.getSalt();
        
        String password = String.format("%s%s", saltDb, userRequest.getPassword());
        String digest = passwordEncoder.encode(password);

        return passwordDb.equals(digest);
    }
}
