package Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReferencesEntity {
    @Id
    @Column(name = "sprints_id", nullable = false)
    private Long sprints_id;

    @Column(name="user_stories_id")
    private Long user_stories_id;

    public Long getUser_stories_id() {
        return user_stories_id;
    }

    public void setUser_stories_id(Long user_stories_id) {
        this.user_stories_id = user_stories_id;
    }

    public Long getSprints_id() {
        return sprints_id;
    }

    public void setSprints_id(Long sprints_id) {
        this.sprints_id = sprints_id;
    }
}
