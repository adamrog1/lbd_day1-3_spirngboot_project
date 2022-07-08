package Services;

import Entity.SprintStatus;
import Entity.SprintsEntity;
import Entity.UserStoriesEntity;
import Entity.UserStoriesStatus;
import Repositories.SprintRepository;
import Repositories.UserStoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

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

    public void saveNewUserStories(UserStoriesEntity entity){
        userStoriesRepository.save(entity);
    }


}
