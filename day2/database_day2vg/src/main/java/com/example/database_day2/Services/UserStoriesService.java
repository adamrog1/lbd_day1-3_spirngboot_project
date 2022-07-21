package com.example.database_day2.Services;


import com.example.database_day2.Repositories.SprintRepository;
import com.example.database_day2.Repositories.UserStoriesRepository;
import com.example.database_day2.Entity.*;
import com.example.database_day2.dto.StoryDto;
import org.apache.catalina.User;
import org.springframework.data.domain.PageRequest;
import java.awt.print.Pageable;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.*;

@Service
public class UserStoriesService {




    private  SprintRepository sprintRepository;
    private UserStoriesRepository userStoriesRepository;
    private ConvertService convertService;

    public UserStoriesService(SprintRepository sprintRepository, UserStoriesRepository userStoriesRepository,
                              ConvertService convertService){
        this.sprintRepository=sprintRepository;
        this.userStoriesRepository=userStoriesRepository;
        this.convertService=convertService;
    }

    public List<UserStoriesEntity> findAll(){
        return (List<UserStoriesEntity>)
                 userStoriesRepository.findAll();
    }

    public List<StoryDto> findAndconvertAll(){

        List<StoryDto> storyDtos=new ArrayList<>();
        for(UserStoriesEntity entity: findAll()){
            storyDtos.add(convertService.convertEntityToDTO(entity));
        }
        return storyDtos;
    }

    public List<StoryDto> getAllStories(){
        return  findAndconvertAll();
    }

    @Transactional
    public UserStoriesEntity saveNewUserStory(UserStoriesEntity entity){
        if(entity.getName()!=null && entity.getDescription()!=null){
            entity.getStatusIfNull();

            return userStoriesRepository.save(entity);
        }
        return null;
    }

    public String getUserStoryDescription(Long id){
        StoryDto storyDto=convertService.convertEntityToDTO(userStoriesRepository.findById(id).get());
        return storyDto.getDescription();
    }

    public void setNewAttachemnt(Long id, MultipartFile file) throws IOException {
        byte [] byteArr=file.getBytes();
        UserStoriesEntity entity;
        entity= userStoriesRepository.findById(id).get();
        entity.setAttachments(byteArr);
        userStoriesRepository.save(entity);

    }
    public void deleteStory(Long id){
        userStoriesRepository.deleteById(id);
    }
//TODO
//    public List<StoryDto> getSortedStoriesByName(int pageSize){
//        Pageable pageable= (Pageable) PageRequest.of(0,pageSize);
//        List<UserStoriesEntity> us=userStoriesRepository.findAllWithPage(pageable);
//
//        us= findAll().stream().sorted(Comparator.comparing(UserStoriesEntity::getName)).toList();
//        List<StoryDto> storyDtos=new ArrayList<>();
//        for(UserStoriesEntity userStories:us){
//           storyDtos.add(convertService.convertEntityToDTO(userStories));
//        }
//
//        return storyDtos;

//    }



//    public int getStoryPoints(SprintsEntity entity){
//
//    }

}
