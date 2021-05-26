package com.simkin.usrPool.entity;

import com.simkin.usrPool.model.Question;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class PoolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private boolean active;
    private Date startDate;
    private Date endDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pool")
    private List<QuestionEntity> qstInPool;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public PoolEntity() {

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        if (this.startDate == null) {
            this.startDate = startDate;
        } else {
            throw new RuntimeException("Нельзя изменить дату начала опроса");
        }
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<QuestionEntity> getQstInPool() {
        return qstInPool;
    }

    public void setQstInPool(List<QuestionEntity> qstInPool) {
        this.qstInPool = qstInPool;
    }
}
