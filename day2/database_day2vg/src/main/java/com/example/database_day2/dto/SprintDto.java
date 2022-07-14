package com.example.database_day2.dto;

import com.example.database_day2.Entity.SprintStatus;
import com.example.database_day2.Entity.UserStoriesEntity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class SprintDto {
    private Long id;
    private String name;
    private String description;
    private Date start_date;
    private Date end_date;
    private SprintStatus status;
    private Set<UserStoriesEntity> UserStories=new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public SprintStatus getStatus() {
        return status;
    }

    public void setStatus(SprintStatus status) {
        this.status = status;
    }

    public Set<UserStoriesEntity> getUserStories() {
        return UserStories;
    }

    public void setUserStories(Set<UserStoriesEntity> userStories) {
        UserStories = userStories;
    }
}
