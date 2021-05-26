package com.simkin.usrPool.repository;

import com.simkin.usrPool.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByFirstName(String firstName);
    UserEntity findByLastName(String lastName);
}
