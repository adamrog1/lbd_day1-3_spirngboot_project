package com.example.database_day2.Controllers;

import com.example.database_day2.Entity.UserStoriesEntity;
import com.example.database_day2.Listeners.CreateStoryEvent;
import com.example.database_day2.Services.UserStoriesService;
import com.example.database_day2.dto.StoryDto;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

@RestController
public class UserStoriesController {

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;
    @Autowired
    UserStoriesService userStoriesService;

    @PostMapping("/addStory")
    public UserStoriesEntity addStory(@RequestBody UserStoriesEntity stories){
        applicationEventPublisher.publishEvent(
                new CreateStoryEvent(userStoriesService.saveNewUserStory(stories).getId()));

        return stories;
    }

    @GetMapping("/getStories")
    public List<StoryDto> getAllStories(){
        return userStoriesService.getAllStories();
    }

    @GetMapping("/getStoriesDescription/{story_id}")
    public String getStoriesDescription(@PathVariable Long story_id){
        return userStoriesService.getUserStoryDescription(story_id);
    }

    @PostMapping("/setNewAttachment")
    public String setNewAttachment(@RequestParam Long id , @RequestBody MultipartFile file) throws IOException {
        userStoriesService.setNewAttachemnt(id, file);
        return file.toString();
    }

    @DeleteMapping("/deleteStory/{id}")
    public void deleteStory(@PathVariable Long id){
        userStoriesService.deleteStory(id);
    }

    @GetMapping("/getAllStoriesSorted/{pages}/{size}")
    public List<StoryDto> getAllStoriesSortedByName(@PathVariable int pages, @PathVariable int size){
        return userStoriesService.findAllPageAndSortByDate(pages,size);
    }
    @GetMapping("/getUserStoriesBySprintId/{sprintID}")
    List<StoryDto> getUserStoiresBySprintId(@PathVariable Long sprintID){
        return userStoriesService.getUserStoriesBySprintId(sprintID);
    }
    @PostMapping("/generate100Stories")
    public void generate(){
        userStoriesService.generate100randomStories();
    }
}
