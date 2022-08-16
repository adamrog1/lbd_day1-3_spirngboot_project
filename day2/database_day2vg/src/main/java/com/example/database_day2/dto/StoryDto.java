package com.example.database_day2.dto;

import com.example.database_day2.Entity.SprintsEntity;
import com.example.database_day2.Entity.UserStoriesStatus;

import java.util.HashSet;
import java.util.Set;

public class StoryDto {

    private Long id;
    private Set<SprintsEntity> sprintsSet=new HashSet<>();
    private String name;
    private String description;
    private UserStoriesStatus status;
    private byte[]  attachments;
    private int story_points;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserStoriesStatus getStatus() {
        return status;
    }

    public void setStatus(UserStoriesStatus status) {
        this.status = status;
    }

    public byte[]  getAttachments() {
        return attachments;
    }

    public void setAttachments(byte[] attachments) {
        this.attachments=attachments;
    }

    public int getStory_points() {
        return story_points;
    }

    public void setStory_points(int story_points) {
        this.story_points = story_points;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<SprintsEntity> getSprintsSet() {
        return sprintsSet;
    }

    public void setSprintsSet(Set<SprintsEntity> sprintsSet) {
        this.sprintsSet = sprintsSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StoryDto{" +
                "id=" + id +
                ", name='" + name + '\'';
    }
}
