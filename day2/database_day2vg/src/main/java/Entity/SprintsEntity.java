package Entity;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "Sprints")
public class SprintsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public SprintsEntity(Long id, String name, String description, Date start_date, Date end_date, SprintStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;

        this.status = status;
    }

    @Column(name = "name")
    private String name;

    @Column(name= "description")
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

    public String getStatus(){
        return status.toString();
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


}
