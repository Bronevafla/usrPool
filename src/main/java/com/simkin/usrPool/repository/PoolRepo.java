package com.simkin.usrPool.repository;

import com.simkin.usrPool.entity.PoolEntity;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;

public interface PoolRepo extends CrudRepository<PoolEntity, Long> {
    PoolEntity findByDescription(String description);
    PoolEntity findByStartDate(Date startDate);
    PoolEntity findAllByActive(boolean active);
}
