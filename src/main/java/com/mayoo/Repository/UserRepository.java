package com.mayoo.Repository;

import com.mayoo.Entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findUserEntityByEmail(String email);
    Optional<UserEntity> findUserEntityByFirstNameAndLastName(String firstName, String lastName);
}
