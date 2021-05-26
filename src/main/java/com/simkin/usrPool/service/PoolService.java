package com.simkin.usrPool.service;

import com.simkin.usrPool.entity.PoolEntity;
import com.simkin.usrPool.entity.QuestionEntity;
import com.simkin.usrPool.entity.UserEntity;
import com.simkin.usrPool.exception.PoolAlreadyExistException;
import com.simkin.usrPool.model.Pool;
import com.simkin.usrPool.model.User;
import com.simkin.usrPool.repository.PoolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoolService {

    @Autowired
    private PoolRepo poolRepo;

    public PoolEntity createPool(PoolEntity pool) throws PoolAlreadyExistException {
        if (poolRepo.existsById(pool.getId()) &&
                poolRepo.findByStartDate(pool.getStartDate()) != null) {
            throw new PoolAlreadyExistException("Данный опрос уже существует");
        }
        return poolRepo.save(pool);
    }

    public Pool getOne(Long id){
        PoolEntity pool = poolRepo.findById(id).get();
        if(!poolRepo.existsById(id)){
            throw new RuntimeException("Данный опрос не существует");
        }
        return Pool.toModel(pool);
    }

    public Long delete(Long id){
        poolRepo.deleteById(id);
        return id;
    }

    public PoolEntity updatePool(Long id, String description){
        PoolEntity pool = poolRepo.findById(id).get();
        pool.setDescription(description);
        return poolRepo.save(pool);
    }

    public PoolEntity getAllActive(){
        return poolRepo.findAllByActive(true);
    }
}


