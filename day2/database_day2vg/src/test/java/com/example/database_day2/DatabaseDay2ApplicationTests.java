package com.example.database_day2;

import com.example.database_day2.Entity.SprintStatus;
import com.example.database_day2.Entity.SprintsEntity;
import com.example.database_day2.Entity.UserStoriesEntity;
import com.example.database_day2.Entity.UserStoriesStatus;
import com.example.database_day2.Services.UserStoriesService;
import com.example.database_day2.Services.SprintService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.PostConstruct;
import java.sql.Date;

@SpringBootTest
class DatabaseDay2ApplicationTests {

    @Autowired
    SprintService sprintService;
    @Autowired
    UserStoriesService userStoriesService;
    @Test
    void contextLoads() {
    }

//    @Test
//    @PostConstruct
//    void testSavingEntity(){
//        Date start_date=new Date(2020,1,20);
//        Date end_date=new Date(2020,6,21);
//        SprintsEntity sprintsEntity=new SprintsEntity("ta","no",start_date,end_date,SprintStatus.Pending);
//
//        UserStoriesEntity userStories=new UserStoriesEntity("aw","raw",UserStoriesStatus.To_do, new byte[]{(byte) 1},2);
//
//
//        sprintService.saveNewSprint(sprintsEntity);
//        userStoriesService.saveNewUserStory(userStories);
//
//    }

//    @Test
//    void getUserStoriesFromSprintsByID(){
//        userStoriesService.getUserStoriesBySprintId(1L);
//    }

//    @Test
//    void getSprintTest(){
//        Date
//        dataBaseService.getSprintsByDate()
//    }


}
