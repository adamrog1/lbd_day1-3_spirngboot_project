package com.example.database_day2.Services;


import com.example.database_day2.Entity.UserStoriesEntity;
import com.example.database_day2.Entity.UserStoriesStatus;
import com.example.database_day2.Repositories.SprintRepository;
import com.example.database_day2.Repositories.UserStoriesRepository;
import com.example.database_day2.dto.StoryDto;
import net.bytebuddy.utility.RandomString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

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

        List<StoryDto> storyDtos;
        storyDtos= findAll().stream().map(element->convertService.convertEntityToDTO(element)).collect(toList());
        return storyDtos;
    }

    public List<StoryDto> getAllStories(){
        return  findAndconvertAll();
    }

    @Transactional
    public UserStoriesEntity saveNewUserStory(UserStoriesEntity entity){
        if(entity.getName()!=null && entity.getDescription()!=null){
            entity.getStatus();

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

    public List<StoryDto> findAllPageAndSortByDate(Integer page, Integer size) {

        Page<UserStoriesEntity> userStoriesEntities= userStoriesRepository.findAll(PageRequest.of(page, size,
                        Sort.by("name")));
        return userStoriesEntities.getContent().stream().map(element-> convertService.convertEntityToDTO(element)).toList();
    }

    public List<StoryDto> getUserStoriesBySprintId(Long id){
        Set<UserStoriesEntity> userStoriesEntities;
        userStoriesEntities= sprintRepository.findById(id).get().getUserStories();
        System.out.println(userStoriesEntities);
        List<StoryDto> list;
        list=userStoriesEntities.stream().map(element-> convertService.convertEntityToDTO(element)).toList();
        return list;
    }

    public void generate100randomStories(){
        for(int i=0;i<100;i++) {
            String generateName = RandomString.make(10);
            String generateDescription = RandomString.make(10);
            int points = (int) (Math.random() * 100);
            UserStoriesEntity stories = new UserStoriesEntity(generateName, generateDescription,
                    UserStoriesStatus.In_progress, null, points);
            userStoriesRepository.save(stories);
        }
    }
}
