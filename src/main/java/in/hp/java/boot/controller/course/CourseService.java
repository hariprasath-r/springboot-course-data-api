package in.hp.java.boot.controller.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	/*
	 * Autowiring the dependency so spring will initialize the repository
	 */
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses() {
		List<Course> courses = new ArrayList<>();
		
		/*
		 * The findAll() method of Spring JPA returns an Iterable of Topic objects after retrieving it from the DB, all the connections and other stuffs are taken care by Spring
		 * We need to iterate through the Iterable and create a list and send it back, for that we are using MethodReferences in Java 8.
		 */
		courseRepository.findAll().forEach(courses :: add);
		
		return courses;
	}
	
	public Course getCourse(String id) {
		return courseRepository.findById(id).get();
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
