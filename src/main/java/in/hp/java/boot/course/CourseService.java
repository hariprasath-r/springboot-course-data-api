package in.hp.java.boot.course;

import in.hp.java.boot.exceptions.ResourceNotFoundException;
import in.hp.java.boot.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CourseService {

	/*
	 * Autowiring the dependency so spring will initialize the repository
	 */
	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private TopicService topicService;

	public List<Course> getAllCourses(String topicId) {
		/*
		 * The findAll() method of Spring JPA returns an Iterable of Topic objects after
		 * retrieving it from the DB, all the connections and other stuffs are taken
		 * care by Spring We need to iterate through the Iterable and create a list and
		 * send it back, for that we are using MethodReferences in Java 8.
		 * 
		 * findByTopicId is a custom method created in CourseRepository interface using
		 * Spring Data JPA accepts a topic id and returns back all the courses
		 * associated with the topic
		 */
		return topicService.getTopic(topicId).getCourses();
	}

	public Course getCourse(String topicId, String courseId) {
		/*
		 To validate Topic Id is present or not
		 We can also get course from list of courses for the specified topic
		 Later while expanding feature with hibernate named queries will do changes here
		 */
		topicService.getTopic(topicId);
		return getCourse(courseId);
	}

	public Course getCourse(String id) {
		/*
		 * Using orElseThrow to throw unchecked exception
		 */
		return courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public void addCourse(String topicId, Course course) {
		/*
		 * Method saves the topic instance to the database
		 */
		course.setTopic(topicService.getTopic(topicId));
		courseRepository.save(course);
	}

	public void updateCourse(Course course, String id, String topicId) {
		topicService.getTopic(topicId);
		if (Objects.nonNull(getCourse(id)))
			courseRepository.save(course);
	}

	public void deleteCourse(String id) {
		if (Objects.nonNull(getCourse(id)))
			courseRepository.deleteById(id);
	}

}
