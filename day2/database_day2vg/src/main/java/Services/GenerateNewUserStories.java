package Services;


import Entity.UserStoriesEntity;
import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GenerateNewUserStories {

    public void genarate100RandomRecords(){
        DataBaseService dataBaseService=new DataBaseService();
        UserStoriesEntity random = null;
        for(int i=0;i<100;i++){
            String generatedString= RandomString.make(10);
            String generatedString2=RandomString.make(10);

            random=new UserStoriesEntity(generatedString,generatedString2,Sta);
        }
        dataBaseService.saveNewUserStory(random);
    }
}
