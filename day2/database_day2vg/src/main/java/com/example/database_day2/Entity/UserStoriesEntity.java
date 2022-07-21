package com.example.database_day2.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.yaml.snakeyaml.util.ArrayUtils;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "UserStories")
public class UserStoriesEntity {
    @Id
    @Column(name = "user_stories_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public UserStoriesEntity( String name, String description, UserStoriesStatus status, byte[] attachments, int story_points) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.attachments = attachments;
        this.story_points = story_points;
    }
    @JsonIgnore
    @ManyToMany(mappedBy = "UserStories")
    private Set<SprintsEntity> sprintsSet=new HashSet<>();

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private UserStoriesStatus status;

    @Column(name= "attachments")
    @Lob
    private byte[] attachments;
    @Column(name="story_points")
    private int story_points;


    public UserStoriesEntity() {

    }

    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }

    public UserStoriesStatus getStatusIfNull() {
        if(status==null)  return status= UserStoriesStatus.valueOf(UserStoriesStatus.In_progress.toString());
        else  return status;
    }

    public void setUserStoriesStatus(UserStoriesStatus status){
        this.status=status;
    }
    public byte[]  getAttachments() {
        return attachments;
    }

    public int getStory_points() {
        return story_points;
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

    public void setAttachments(byte[] attachments) {
        this.attachments=attachments;
    }

    @Override
    public String toString(){
        return id+ " " + name+ " " + description+ " " + status;
    }
}
