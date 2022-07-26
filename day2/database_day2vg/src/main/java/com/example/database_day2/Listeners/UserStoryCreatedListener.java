package com.example.database_day2.Listeners;

import com.example.database_day2.Entity.SprintStatus;
import com.example.database_day2.Entity.SprintsEntity;
import com.example.database_day2.Repositories.SprintRepository;
import com.example.database_day2.Services.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

@Component
public class UserStoryCreatedListener {

    @Autowired
    SprintService sprintService;
    @Autowired
    SprintRepository sprintRepository;

    @EventListener
    public void handleStoryCreatedEvent(CreateStoryEvent createStoryEvent) throws SQLException {
        ArrayList<SprintsEntity> list=new ArrayList<>();
        for(SprintsEntity sprints: sprintRepository.findAll()){
            if(sprints.getStatus()== SprintStatus.Pending) list.add(sprints);
        }
        list.sort(Comparator.comparingLong(SprintsEntity::getId).reversed());
        if(!list.isEmpty()) sprintService.addUserStoryToSprint(createStoryEvent.getStory_id(),list.get(0).getId());

    }
}
