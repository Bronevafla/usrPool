package com.simkin.usrPool.entity;

import javax.persistence.*;

@Entity
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private String type;
    private String askTheQuestion;
    private boolean resolve;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private PoolEntity pool;

    public QuestionEntity(){

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

    public String getAskTheQuestion() {
        return askTheQuestion;
    }

    public void setAskTheQuestion(String askTheQuestion) {
        this.askTheQuestion = askTheQuestion;
    }

    public PoolEntity getPool() {
        return pool;
    }

    public void setPool(PoolEntity pool) {
        this.pool = pool;
    }

    public boolean getResolve() {
        return resolve;
    }

    public void setResolve(boolean resolve) {
        this.resolve = resolve;
    }
}
