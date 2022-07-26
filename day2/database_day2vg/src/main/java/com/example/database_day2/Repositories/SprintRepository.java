package com.example.database_day2.Repositories;

import com.example.database_day2.Entity.SprintsEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public interface SprintRepository extends PagingAndSortingRepository<SprintsEntity,Long> {
    SprintsEntity findTopByOrderByIdDesc();
}
