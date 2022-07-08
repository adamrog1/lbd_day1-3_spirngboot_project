package Repositories;

import Entity.UserStoriesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserStoriesRepository extends CrudRepository<UserStoriesEntity,Long> {
}
