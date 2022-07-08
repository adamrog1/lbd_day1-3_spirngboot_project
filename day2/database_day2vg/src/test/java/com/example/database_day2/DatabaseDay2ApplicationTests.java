package com.example.database_day2;

import Entity.SprintStatus;
import Entity.SprintsEntity;
import Repositories.SprintRepository;
import Repositories.UserStoriesRepository;
import Services.DataBaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

@SpringBootTest
class DatabaseDay2ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testSavingEntity(){
        Date start_date=new Date(2020,1,20);
        Date end_date=new Date(2020,6,21);
        SprintsEntity sprintsEntity=new SprintsEntity
                (1L,"ta","fajne",start_date,end_date,"", SprintStatus.Pending);
        DataBaseService dataBaseService=new DataBaseService();
        dataBaseService.saveNewSprint(sprintsEntity);

    }

}
