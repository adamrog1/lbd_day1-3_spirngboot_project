package com.example.database_day2.Controllers;

import com.example.database_day2.Entity.UserStoriesEntity;
import com.example.database_day2.Services.UserStoriesService;
import com.example.database_day2.dto.StoryDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
