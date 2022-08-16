package com.example.database_day2.Repositories;

import com.example.database_day2.Entity.UserStoriesEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStoriesRepository extends PagingAndSortingRepository<UserStoriesEntity,Long> {

}
