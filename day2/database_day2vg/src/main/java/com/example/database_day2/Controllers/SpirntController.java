package com.example.database_day2.Controllers;

import com.example.database_day2.Entity.SprintStatus;
import com.example.database_day2.Entity.SprintsEntity;
import com.example.database_day2.Entity.UserStoriesEntity;
import com.example.database_day2.Services.SprintService;
import com.example.database_day2.Services.UserStoriesService;
import com.example.database_day2.dto.SprintDto;
import com.example.database_day2.dto.StoryDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
public class SpirntController {
    @Autowired
    SprintService sprintService;

    @PostMapping("/addSprint")
    public SprintsEntity addSprint(@RequestBody SprintsEntity sprint) throws SQLException {
        return sprintService.saveNewSprint(sprint);
    }

    @PutMapping("/{storyID}/stories/{sprintID}")
    SprintsEntity addStoryToSprint(@PathVariable Long storyID, @PathVariable Long sprintID) throws SQLException {
        return sprintService.addUserStoryToSprint(storyID, sprintID);
    }

    @GetMapping("/getPointsOfDoneStories/{sprintID}")
    int getPointOfDoneStories(@PathVariable Long sprintID){
        return sprintService.getUserStoryPointsIfStatusIsDone(sprintID);
    }

    @PostMapping("/updateSprintStatus")
    SprintDto updateSprintStatus(@RequestParam Long id, @RequestParam("status") SprintStatus status) {
            return sprintService.updateSprintStatus(id,status);
    }

    @GetMapping("/getSprintsByDate")
    List<SprintDto> getSprintsByDate(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date dateFrom,
                                     @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date dateTo){
        return sprintService.getSprintsByDate(dateFrom,dateTo);
    }


}
