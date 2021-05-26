package com.simkin.usrPool.service;

import com.simkin.usrPool.entity.PoolEntity;
import com.simkin.usrPool.entity.QuestionEntity;
import com.simkin.usrPool.exception.QuestionAlreadyExistException;
import com.simkin.usrPool.exception.QuestionIsNotExistException;
import com.simkin.usrPool.model.Question;
import com.simkin.usrPool.repository.PoolRepo;
import com.simkin.usrPool.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private PoolRepo poolRepo;

//    public QuestionEntity createQuestion(QuestionEntity question) throws QuestionAlreadyExistException {
//        if(questionRepo.findByText(question.getText()) != null){
//            throw new QuestionAlreadyExistException("Данный вопрос уже существует");
//        }
//        return questionRepo.save(question);
//    }

    public QuestionEntity create(QuestionEntity question, Long poolId){
        PoolEntity pool = poolRepo.findById(poolId).get();
        question.setPool(pool);
        return questionRepo.save(question);
    }

    public Question getOne(Long id) throws QuestionIsNotExistException {
        QuestionEntity question = questionRepo.findById(id).get();
        if(!questionRepo.existsById(id)){
            throw new QuestionIsNotExistException("Вопрос не существует");
        }
        return Question.toModel(question);
    }

    public Long delete(Long id){
        questionRepo.deleteById(id);
        return id;
    }

    public QuestionEntity completeQuestion(Long id){
        QuestionEntity question = questionRepo.findById(id).get();
        question.setResolve(!question.getResolve());
        return questionRepo.save(question);
    }


}
