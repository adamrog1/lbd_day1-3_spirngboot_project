package com.example.database_day2.Listeners;

import org.springframework.stereotype.Component;

@Component
public class CreateStoryEvent {

    private Long story_id;
    public CreateStoryEvent(Long story_id) {
        this.story_id = story_id;
    }

    public Long getStory_id() {
        return story_id;
    }

    public void setStory_id(Long story_id) {
        this.story_id = story_id;
    }

    public CreateStoryEvent() {
    }
}
