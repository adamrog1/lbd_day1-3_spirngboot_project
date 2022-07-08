package Entity;


import javax.persistence.*;

@Entity(name = "User Stories")
public class UserStoriesEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

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

    @Column(name = "sprints")
    private String sprints;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
