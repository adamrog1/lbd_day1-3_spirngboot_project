package Services;

import Entity.*;
import Repositories.ReferencesRepository;
import Repositories.SprintRepository;
import Repositories.UserStoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class DataBaseService {



    @Autowired
    private  SprintRepository sprintRepository;

    @Autowired
    private UserStoriesRepository userStoriesRepository;

    @Autowired
    private ReferencesRepository referencesRepository;


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
        Iterable<ReferencesEntity> found=new ArrayList<>();
        ArrayList<Long> userStoriesIds=new ArrayList<>();
        SprintsEntity sprintsEntity= sprintRepository.findById(id).get();
        found= referencesRepository.findAllById(Collections.singleton(sprintsEntity.getId()));
        for(ReferencesEntity f: found){
            userStoriesIds.add(f.getUser_stories_id());
        }
        userStoriesRepository.findAllById(userStoriesIds).forEach(entity -> System.out.println(entity.toString()));

    }

    public List<SprintsEntity> getSprintsByDate(java.sql.Date from, Date to){
        List<SprintsEntity> entities = new ArrayList<>();
        sprintRepository.findAll().forEach(entities::add);
        entities.removeIf(e -> e.getStart_date().compareTo(from) > 0 || e.getStart_date().compareTo(to) < 0);
        return entities;

    }

    public int getStoryPoints(SprintsEntity entity){
        Iterable<ReferencesEntity> found=new ArrayList<>();
        ArrayList<Long> userStoriesIds=new ArrayList<>();
        SprintsEntity sprintsEntity= sprintRepository.findById(entity.getId()).get();
        found= referencesRepository.findAllById(Collections.singleton(sprintsEntity.getId()));
        for(ReferencesEntity f: found){
            userStoriesIds.add(f.getUser_stories_id());
        }
        AtomicInteger sum= new AtomicInteger();
        userStoriesRepository.findAllById(userStoriesIds).forEach(entity1 -> sum.addAndGet(
        entity1.getStory_points()));
        return sum.intValue();
    }

}
