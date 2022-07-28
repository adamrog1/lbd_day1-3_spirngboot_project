package com.example.database_day2;

import com.example.database_day2.Entity.SprintStatus;
import com.example.database_day2.Entity.SprintsEntity;
import com.example.database_day2.Entity.UserStoriesEntity;
import com.example.database_day2.Entity.UserStoriesStatus;
import com.example.database_day2.Repositories.UserStoriesRepository;
import com.example.database_day2.Services.ConvertService;
import com.example.database_day2.Services.UserStoriesService;
import com.example.database_day2.Services.SprintService;
import com.jayway.jsonpath.JsonPath;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import javax.annotation.PostConstruct;
import java.sql.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class DatabaseDay2ApplicationTests {

    @Autowired
    SprintService sprintService;
    @Autowired
    UserStoriesService userStoriesService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    @PostConstruct
    void testSavingEntity(){
        Date start_date=new Date(2020,1,20);
        Date end_date=new Date(2020,6,21);
        SprintsEntity sprintsEntity=new SprintsEntity("ta","no",start_date,end_date,SprintStatus.Pending);

        UserStoriesEntity userStories=new UserStoriesEntity("aw","raw",UserStoriesStatus.To_do, null,2);


        sprintService.saveNewSprint(sprintsEntity);
        userStoriesService.saveNewUserStory(userStories);
    }

    @Test
    void testChangingSprintStatus() throws Exception{
        Long id=1L;
        SprintStatus status=SprintStatus.Canceled;
        mockMvc.perform((MockMvcRequestBuilders.post("/updateSprintStatus")
                .param("id",id.toString())
                .param("status",status.toString())))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$").isMap())
                .andExpect(jsonPath("$.status", Is.is("Canceled")));
    }

    @Test
    void testDeletingStory() throws Exception{
        userStoriesService.generate100randomStories();
        mockMvc.perform(MockMvcRequestBuilders.delete("/deleteStory/90"))
                .andExpect(status().isOk());
    }

    @Test
    @PostConstruct
    void testGetUserStoryDescription() throws Exception{
        UserStoriesEntity userStory=new UserStoriesEntity("name","tak",UserStoriesStatus.In_progress,null,5);
        userStoriesService.saveNewUserStory(userStory);
        mockMvc.perform(MockMvcRequestBuilders.get("/getStoriesDescription/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("tak"));
    }



//    @Test
//    @PostConstruct
//    void getUserStoriesFromSprintsByID(){
//        userStoriesService.getUserStoriesBySprintId(1L);
//    }

//    @Test
//    void getSprintTest(){
//        Date
//        dataBaseService.getSprintsByDate()
//    }


}
