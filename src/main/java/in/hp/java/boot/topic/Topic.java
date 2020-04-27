package in.hp.java.boot.topic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.hp.java.boot.course.Course;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@ApiModel("Topic Details")
public class Topic {

    @Id
    @Size(min = 2, message = "Id should be of 2 chars minimum")
    @ApiModelProperty(notes = "Id should be of 2 chars minimum")
    private String id;

    @Size(min = 4, message = "Name should be of 4 chars minimum")
    @ApiModelProperty(notes = "Name should be of 4 chars minimum")
    private String name;
    private String description;

    /**
     * Ignoring this to avoid recursive loop in object to json conversion
     * Since course have user.
     */
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "topic")
    private List<Course> courses;

    public Topic() {
        super();
    }

    public Topic(String id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
