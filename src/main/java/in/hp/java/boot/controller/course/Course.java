package in.hp.java.boot.controller.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import in.hp.java.boot.controller.topic.Topic;

@Entity
public class Course {

	@Id
	private String id;
	private String name;
	private String description;

	/*
	 * Adding JPA @ManyToOne annotation to let Spring JPA know it needs to establish
	 * a Foreign Key relationship
	 * 
	 * TODO FetchType can be made LAZY
	 */
	@ManyToOne()
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
