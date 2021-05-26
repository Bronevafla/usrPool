package com.simkin.usrPool.model;

import com.simkin.usrPool.entity.PoolEntity;
import com.simkin.usrPool.entity.QuestionEntity;

import java.util.List;
import java.util.stream.Collectors;

public class Pool {
    private Long id;
    private String description;
    private List<Question> qstList;


    public static Pool toModel(PoolEntity entity){
        Pool model = new Pool();
        model.setId(entity.getId());
        model.setDescription(entity.getDescription());
        model.setQstList(entity.getQstInPool().stream().map(Question::toModel).collect(Collectors.toList()));
        return model;
    }

    public Pool(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Question> getQstList() {
        return qstList;
    }

    public void setQstList(List<Question> qstList) {
        this.qstList = qstList;
    }
}
