package com.example.database_day2.Repositories;

import com.example.database_day2.Entity.UserStoriesEntity;
import com.example.database_day2.dto.StoryDto;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface UserStoriesRepository extends PagingAndSortingRepository<UserStoriesEntity,Long> {

}
