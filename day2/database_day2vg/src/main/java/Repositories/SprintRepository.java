package Repositories;

import Entity.SprintsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintRepository extends CrudRepository<SprintsEntity,Long> {
}
