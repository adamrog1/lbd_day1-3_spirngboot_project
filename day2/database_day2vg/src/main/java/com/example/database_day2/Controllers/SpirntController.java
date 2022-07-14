package com.example.database_day2.Controllers;

import com.example.database_day2.Entity.SprintsEntity;
import com.example.database_day2.Entity.UserStoriesEntity;
import com.example.database_day2.Services.SprintService;
import com.example.database_day2.Services.UserStoriesService;
import com.example.database_day2.dto.StoryDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class SpirntController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    SprintService sprintService;

    @PostMapping("/addSprint")
    public SprintsEntity addSprint(@RequestBody SprintsEntity sprint){
        return sprintService.saveNewSprint(sprint);
    }

    @PutMapping("/{storyID}/stories/{sprintID}")
    SprintsEntity addStoryToSprint(@PathVariable Long storyID, @PathVariable Long sprintID){
        return sprintService.addUserStoryToSprint(storyID, sprintID);
    }

    @GetMapping("/getPointsOfStories/{sprintID}")
    int getPointOfStories(@PathVariable Long sprintID){
        return sprintService.getUserStoryPoints(sprintID);
    }

    @GetMapping("/getUserStoriesBySprintId/{sprintID}")
    Set<UserStoriesEntity> getUserStoiresBySprintId(@PathVariable Long sprintID){
        return sprintService.getUserStoriesBySprintId(sprintID);
    }


}
