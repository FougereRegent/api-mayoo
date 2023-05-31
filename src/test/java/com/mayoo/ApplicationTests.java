package com.mayoo;

import com.mayoo.Repository.UserRepository;
import com.mayoo.Service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void test_create_user_check_email() {
    }
    @Test
    public void test_create_user_check_password () {
    }
    @Test
    public void test_create_user_check_username() {
    }
    @Test
    public void test_create_user_check_exist() {
    }
}