package com.example.database_day2.Services;


import com.example.database_day2.Repositories.SprintRepository;
import com.example.database_day2.Repositories.UserStoriesRepository;
import com.example.database_day2.Entity.*;
import com.example.database_day2.dto.StoryDto;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

@Service
public class UserStoriesService {




    private  SprintRepository sprintRepository;
    private UserStoriesRepository userStoriesRepository;
    private ConvertService convertService;

    public UserStoriesService(SprintRepository sprintRepository, UserStoriesRepository userStoriesRepository, ConvertService convertService){
        this.sprintRepository=sprintRepository;
        this.userStoriesRepository=userStoriesRepository;
        this.convertService=convertService;
    }

    public List<UserStoriesEntity> findAll(){
        return (List<UserStoriesEntity>)
                 userStoriesRepository.findAll();
    }

    public List<StoryDto> convertAll(){
        List<StoryDto> storyDtos=new ArrayList<>();
        for(UserStoriesEntity entity: findAll()){
            storyDtos.add(convertService.convertEntityToDTO(entity));
        }
        return storyDtos;
    }

    public List<StoryDto> getAllStories(){

        return  convertAll();
    }

    @Transactional
    public UserStoriesEntity saveNewUserStory(UserStoriesEntity entity){
        if(entity.getName()!=null && entity.getDescription()!=null){
            entity.getStatusIfNull();

            return userStoriesRepository.save(entity);
        }
        return null;
    }



    @Transactional
    public void getUserStoriesBySprintId(Long id){


    }

    public List<SprintsEntity> getSprintsByDate(java.sql.Date from, Date to){
        List<SprintsEntity> entities = new ArrayList<>();
        sprintRepository.findAll().forEach(entities::add);
        entities.removeIf(e -> e.getStart_date().compareTo(from) > 0 || e.getStart_date().compareTo(to) < 0);
        return entities;

    }

//    public int getStoryPoints(SprintsEntity entity){
//
//    }

}
