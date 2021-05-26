package com.simkin.usrPool.repository;

import com.simkin.usrPool.entity.QuestionEntity;
import com.simkin.usrPool.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepo extends CrudRepository<QuestionEntity, Long> {
    QuestionEntity findByText(String text);
}
