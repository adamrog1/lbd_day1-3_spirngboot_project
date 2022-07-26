package com.example.database_day2.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Sprints")
public class SprintsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sprints_id", nullable = false)
    private Long id;


    public SprintsEntity( String name, String description, Date start_date, Date end_date, SprintStatus status) {
        this.name = name;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;

        this.status = status;
    }


    @ManyToMany
    @JoinTable(name = "sprint_stories"
    ,joinColumns = @JoinColumn(name="sprint_id"),
    inverseJoinColumns = @JoinColumn(name = "user_stories_id")
    )
    private Set<UserStoriesEntity> UserStories=new HashSet<>();
    @Column(name = "name")
    private String name;

    @Column(name= "description_of_aim")
    private String description;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private SprintStatus status;

    public SprintsEntity() {

    }

    public Long getId() {
        return id;
    }

    public SprintStatus getStatus(){
        return status;
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

    public void setStatus(SprintStatus status) {
        this.status = status;
    }

    public void addUserStory(UserStoriesEntity userStories){
        UserStories.add(userStories);
    }

    public Set<UserStoriesEntity> getUserStories() {
        return UserStories;
    }

    public void setUserStories(Set<UserStoriesEntity> userStories) {
        UserStories = userStories;
    }


}
