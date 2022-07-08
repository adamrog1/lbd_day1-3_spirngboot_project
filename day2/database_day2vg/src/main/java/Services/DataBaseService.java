package Services;

import Entity.SprintStatus;
import Entity.SprintsEntity;
import Entity.UserStoriesEntity;
import Entity.UserStoriesStatus;
import Repositories.SprintRepository;
import Repositories.UserStoriesRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DataBaseService {



    @Autowired
    private  SprintRepository sprintRepository;

    @Autowired
    private UserStoriesRepository userStoriesRepository;


    private boolean ifContainsEnum(String s){
        for(SprintStatus c : SprintStatus.values()) {
            if (c.name().equals(s)) return true;

        }
        for(UserStoriesStatus c : UserStoriesStatus.values()) {
            if(c.name().equals(s)) return true;
        }
        return false;
    }


    public void saveNewSprint(SprintsEntity entity){
        if(entity.getId()!= null && entity.getName()!=null
                && entity.getEnd_date()!=null && entity.getStart_date()!=null
                && entity.getStart_date().compareTo(entity.getEnd_date())<0
                && ifContainsEnum(entity.getStatus())){

            sprintRepository.save(entity);
        }
    }

    public void saveNewUserStory(UserStoriesEntity entity){
        if(entity.getId()!=null && entity.getName()!=null && entity.getDescription()!=null){
            if(entity.getStatus()==null) entity.setUserStoriesStatus(UserStoriesStatus.To_do);
            userStoriesRepository.save(entity);
        }
    }

    public void getUserStories(Long id){
        SprintsEntity entity= sprintRepository.findById(id).get();
        

    }

    public List<SprintsEntity> getSprintsByDate(java.sql.Date from, Date to){
        List<SprintsEntity> entities = new ArrayList<>();
        sprintRepository.findAll().forEach(entities::add);
        entities.removeIf(e -> e.getStart_date().compareTo(from) > 0 || e.getStart_date().compareTo(to) < 0);
        return entities;

    }

//    public int getStoryPoints(SprintsEntity entity){
//        if(entity.getStatus())
//    }

}
