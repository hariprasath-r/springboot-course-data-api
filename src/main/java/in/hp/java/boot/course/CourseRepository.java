package in.hp.java.boot.course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, String> {

	/*
	 * Custom method to retrieve list of courses by passing "name" as property
	 * 
	 * If needed to implement a custom method follow the naming convention of Spring
	 * find 	-> for searching and retrieving
	 * By 		-> standard
	 * Property	-> Property which is gonna be passed as argument, here "name"
	 * Argument -> Data type must match the Property, but parameter name can be anything
	 * 
	 * Note, no implementation is required, 
	 * 	as Spring Data JPA takes care of it if created a proper method name following the conventions.
	 */
	public List<Course> findByName(String name);
	
	public List<Course> findByDescription(String description);
	
	/*
	 * To Retrieve the courses based on Topic because it has foreign key dependencies,
	 * 	We can create a method like the one below.
	 * Follow the same Spring Data JPA naming convention
	 * find		-> for searching and retrieving
	 * By		-> standard
	 * Model	-> in this case it is "Topic"
	 * Property	-> primary key name of that model "Id"
	 */
	public List<Course> findByTopicId(String topicId);
}
