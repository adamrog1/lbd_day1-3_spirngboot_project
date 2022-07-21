package com.example.database_day2.Controllers;

import com.example.database_day2.Entity.UserStoriesEntity;
import com.example.database_day2.Services.UserStoriesService;
import com.example.database_day2.dto.StoryDto;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
public class UserStoriesController {


    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    UserStoriesService userStoriesService;



    @PostMapping("/addStory")
    public UserStoriesEntity addStory(@RequestBody UserStoriesEntity stories){
        return userStoriesService.saveNewUserStory(stories);
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

    @GetMapping("/getAllStoriesSorted/{pages}")
    public List<StoryDto> getAllStoriesSortedByName(@PathVariable int pages){
        return userStoriesService.getSortedStoriesByName(pages);
    }

}
