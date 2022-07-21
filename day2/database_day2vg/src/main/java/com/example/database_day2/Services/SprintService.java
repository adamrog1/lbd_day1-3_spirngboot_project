package com.example.database_day2.Services;

import com.example.database_day2.Entity.SprintStatus;
import com.example.database_day2.Entity.SprintsEntity;
import com.example.database_day2.Entity.UserStoriesEntity;
import com.example.database_day2.Entity.UserStoriesStatus;
import com.example.database_day2.Repositories.SprintRepository;
import com.example.database_day2.Repositories.UserStoriesRepository;
import com.example.database_day2.dto.SprintDto;
import com.example.database_day2.dto.StoryDto;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class SprintService {

    private SprintRepository sprintRepository;
    private UserStoriesRepository userStoriesRepository;
    private ConvertService convertService;


    public SprintService(SprintRepository sprintRepository, UserStoriesRepository userStoriesRepository, ConvertService convertService){
        this.sprintRepository=sprintRepository;
        this.userStoriesRepository=userStoriesRepository;
        this.convertService=convertService;
    }

    private boolean ifContainsEnum(String  s){
        for(SprintStatus c : SprintStatus.values()) {
            if (c.name().equals(s)) return true;

        }
        for(UserStoriesStatus c : UserStoriesStatus.values()) {
            if(c.name().equals(s)) return true;
        }
        return false;
    }



    @Transactional
    public SprintsEntity saveNewSprint(SprintsEntity entity){

        if( entity.getName()!=null
                && entity.getEnd_date()!=null && entity.getStart_date()!=null
                && entity.getStart_date().compareTo(entity.getEnd_date())<0
                && ifContainsEnum(entity.getStatus().toString())){
            System.out.println("Saving ...");
            return sprintRepository.save(entity);
        }
        return null;
    }

    public SprintsEntity addUserStoryToSprint(Long userId, Long sprintId){
        UserStoriesEntity userStories=userStoriesRepository.findById(userId).get();
        SprintsEntity sprintsEntity=sprintRepository.findById(sprintId).get();
        sprintsEntity.addUserStory(userStories);
        return sprintRepository.save(sprintsEntity);
    }

    public int getUserStoryPoints(Long id){
        AtomicInteger sum= new AtomicInteger();
        convertService.convertEntityToDto(sprintRepository.findById(id).get()).getUserStories()
                .forEach(userStories -> sum.addAndGet(userStories.getStory_points()));
        return sum.intValue();
    }

    public Set<UserStoriesEntity> getUserStoriesBySprintId(Long id){
        Set<UserStoriesEntity> userStoriesEntities;
        List<StoryDto> storyDtos=new ArrayList<>();
        userStoriesEntities= sprintRepository.findById(id).get().getUserStories();
//        for(UserStoriesEntity e: userStoriesEntities){
//            storyDtos.add( convertService.convertEntityToDTO(e));
//        }
        return userStoriesEntities;
    }

    public SprintDto updateSprintStatus(Long id, SprintStatus status) throws IOException {
        SprintsEntity sprintsEntity = sprintRepository.findById(id).get();
        sprintsEntity.setStatus(status);
        return convertService.convertEntityToDto(sprintsEntity);
    }

    public List<SprintDto> getSprintsByDate(Date dateFrom, Date dateTo){
        List<SprintsEntity> entities = new ArrayList<>();
        List<SprintDto> dtos=new ArrayList<>();
        sprintRepository.findAll().forEach(entities::add);
        for(SprintsEntity sprints: entities){
           dtos.add(convertService.convertEntityToDto(sprints));
        }
        dtos.removeIf(e->e.getStart_date().before(dateFrom) );
        dtos.removeIf(e->e.getStart_date().after(dateTo));
        return dtos;

    }


}
