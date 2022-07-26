package com.example.database_day2.Services;

import com.example.database_day2.Entity.SprintsEntity;
import com.example.database_day2.Entity.UserStoriesEntity;
import com.example.database_day2.dto.SprintDto;
import com.example.database_day2.dto.StoryDto;
import org.springframework.stereotype.Service;

@Service
public class ConvertService {

    public SprintDto convertEntityToDto(SprintsEntity entity){
        SprintDto sprintDto=new SprintDto();
        sprintDto.setId(entity.getId());
        sprintDto.setName(entity.getName());
        sprintDto.setEnd_date(entity.getEnd_date());
        sprintDto.setStart_date(entity.getStart_date());
        sprintDto.setUserStories(entity.getUserStories());
        sprintDto.setDescription(entity.getDescription());
        sprintDto.setStatus(entity.getStatus());
        return sprintDto;
    }

    public StoryDto convertEntityToDTO(UserStoriesEntity userStories){
        StoryDto storyDto=new StoryDto();
        storyDto.setId(userStories.getId());
        storyDto.setName(userStories.getName());
        storyDto.setAttachments(userStories.getAttachments());
        storyDto.setStory_points(userStories.getStory_points());
        storyDto.setDescription(userStories.getDescription());
        storyDto.setStatus(userStories.getStatus());
        storyDto.setSprintsSet(userStories.getSprintsSet());
        return storyDto;
    }
}
