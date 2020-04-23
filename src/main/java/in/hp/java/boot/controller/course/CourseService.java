package in.hp.java.boot.controller.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

	/*
	 * Autowiring the dependency so spring will initialize the repository
	 */
	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAllCourses(String topicId) {
		List<Course> courses = new ArrayList<>();

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
		courseRepository.findByTopicId(topicId).forEach(courses::add);

		return courses;
	}

	public Course getCourse(String id) {
		/**
		 * Ideally Optional.isPresent should be used
		 * Optional<Course> course = courseRepository.findById(id);
		 * return course.ifPresent() ? course.get() : null;
		 * or
		 * return course.orElse(null); 
		 */
		return courseRepository.findById(id).orElse(null);
	}

	public void addCourse(Course course) {
		/*
		 * Method saves the topic instance to the database
		 */
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}

}
