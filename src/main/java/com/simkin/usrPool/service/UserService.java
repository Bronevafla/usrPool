package com.simkin.usrPool.service;

import com.simkin.usrPool.entity.UserEntity;
import com.simkin.usrPool.exception.UserAlreadyExistException;
import com.simkin.usrPool.model.User;
import com.simkin.usrPool.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity createUser(UserEntity user) throws UserAlreadyExistException {
        if(userRepo.findByFirstName(user.getFirstName()) != null &&
                userRepo.findByLastName(user.getLastName()) != null){
            throw new UserAlreadyExistException("Пользователь с такими именем и фамилией уже существует");
        }
        return userRepo.save(user);
    }

    public User getOne(Long id){
        UserEntity user = userRepo.findById(id).get();
        if(!userRepo.existsById(id)){
            throw new RuntimeException("Данный пользователь не существует");
        }
        return User.toModel(user);
    }

    public Long delete(Long id){
        userRepo.deleteById(id);
        return id;
    }

}
