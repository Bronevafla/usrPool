package com.simkin.usrPool.model;

import com.simkin.usrPool.entity.QuestionEntity;

public class Question {
    private Long id;
    private String text;
    private String type;
    private Long poolId;


    public static Question toModel(QuestionEntity entity) {
        Question model = new Question();
        model.setId(entity.getId());
        model.setText(entity.getText());
        model.setType(entity.getType());
        return model;
    }

    public Question() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
