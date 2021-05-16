package in.hp.java.boot.topic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.hp.java.boot.course.Course;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

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
     *
     * @Cascade - used to delete the foreign key related data also
     */
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "topic")
    @Cascade(CascadeType.DELETE)
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Topic{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", courses=").append(courses);
        sb.append('}');
        return sb.toString();
    }
}
