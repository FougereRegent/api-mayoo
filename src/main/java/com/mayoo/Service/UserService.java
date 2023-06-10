package com.mayoo.Service;

import com.mayoo.Exceptions.CustomException;
import com.mayoo.Repository.UserRepository;
import com.mayoo.Service.FieldUserCheck.CheckCreatingUserBuilder;
import com.mayoo.Service.FieldUserCheck.IComponentCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserService implements IUserService, UserDetailsService {

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
    public void createUser(com.mayoo.openapi.model.RegisterRequest user) throws CustomException {
        try {
            this.componentCheckCreateUser.execute(user);
        }
        catch (CustomException exception)
        {
            throw exception;
        }
    }

    @Override
    public void logInUser(com.mayoo.openapi.model.AuthenticationRequest user) {

    }

    @Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
