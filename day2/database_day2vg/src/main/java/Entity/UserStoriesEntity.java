package Entity;


import javax.persistence.*;

@Entity(name = "UserStories")
public class UserStoriesEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    public UserStoriesEntity(Long id, String name, String description, UserStoriesStatus status, byte attachments, int story_points) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.attachments = attachments;
        this.story_points = story_points;
    }

    @Column(name="name")
    private String name;

    @Column(name="decription")
    private String description;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private UserStoriesStatus status;

    @Column(name= "attachments")
    private byte attachments;

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

    public String getStatus() {
        return status.toString();
    }

    public void setUserStoriesStatus(UserStoriesStatus status){
        this.status=status;
    }
    public byte getAttachments() {
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
}
