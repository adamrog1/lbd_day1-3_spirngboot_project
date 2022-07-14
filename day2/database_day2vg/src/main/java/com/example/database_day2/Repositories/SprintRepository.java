package com.example.database_day2.Repositories;

import com.example.database_day2.Entity.SprintsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintRepository extends CrudRepository<SprintsEntity,Long> {
}
