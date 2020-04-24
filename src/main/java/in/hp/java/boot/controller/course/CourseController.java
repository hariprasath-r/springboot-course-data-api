package in.hp.java.boot.controller.course;

import in.hp.java.boot.controller.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * Added Root RequestMapping topics URI
 *
 * @author haripr
 */
@RestController
@RequestMapping("/topics")
public class CourseController {

    @Autowired
    private CourseService courseService;

    private static final String SLASHPATH = "/";

    @GetMapping(value = "/{topicId}/courses")
    public List<Course> getCourses(@PathVariable String topicId) {
        return courseService.getAllCourses(topicId);
    }

    @GetMapping(value = "/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable String id) {
        return courseService.getCourse(id);
    }

    @PostMapping(value = "/{topicId}/courses")
    public ResponseEntity<Object> addCourse(@PathVariable String topicId, @Valid @RequestBody Course course) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path(SLASHPATH + course.getId())
                .buildAndExpand()
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{topicId}/courses/{id}")
    public ResponseEntity<Object> updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course, id);
        return ResponseEntity.accepted().body(course);
    }

    @DeleteMapping(value = "/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
    }

}