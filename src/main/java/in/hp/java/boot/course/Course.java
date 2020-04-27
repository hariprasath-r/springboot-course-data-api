package in.hp.java.boot.course;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.hp.java.boot.topic.Topic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

/**
 * @JsonIgnoreProperties - used to ignore certain properties during Json conversion
 * @JsonIgnore - recommended to use
 * @JsonFilter - Indicated that the bean can be filtered
 */
//@JsonIgnoreProperties(value = {"topic"})
//@JsonFilter("SomeBeanFilter")
@ApiModel("Course Details")
@Entity
public class Course {

	@Id
	@Size(min = 2, message = "Id should be of 2 chars minimum")
	@ApiModelProperty(notes = "Id should be of 2 chars minimum")
	private String id;

	@Size(min = 4, message = "Name should be of 4 chars minimum")
	@ApiModelProperty(notes = "Name should be of 4 chars minimum")
	private String name;
	private String description;

	/*
	 * Adding JPA @ManyToOne annotation to let Spring JPA know it needs to establish
	 * a Foreign Key relationship
	 * FetchType can be made LAZY
	 *
	 * @JsonIgnore is used to ignore this field in response
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	private Topic topic;

	public Course() {
		super();
	}

	public Course(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Course(String id, String name, String description, String topicId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		topic = new Topic(topicId, "", "");
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

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}

