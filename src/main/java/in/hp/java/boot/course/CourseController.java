package in.hp.java.boot.course;

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
        /*
         * Code to add Dynamic Filter
        SimpleBeanPropertyFilter simpleBeanPropertyFilter =
                SimpleBeanPropertyFilter.filterOutAllExcept("topic");
        FilterProvider filterProvider =
                new SimpleFilterProvider().addFilter("SomeBeanFilter", simpleBeanPropertyFilter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(courseService.getAllCourses(topicId));
        mappingJacksonValue.setFilters(filterProvider);
        */
        return courseService.getAllCourses(topicId);
    }

    @GetMapping(value = "/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable String topicId, @PathVariable String id) {
        return courseService.getCourse(topicId, id);
    }

    @PostMapping(value = "/{topicId}/courses")
    public ResponseEntity<Object> addCourse(@PathVariable String topicId, @Valid @RequestBody Course course) {
        courseService.addCourse(topicId, course);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path(SLASHPATH + course.getId())
                .buildAndExpand()
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{topicId}/courses/{id}")
    public ResponseEntity<Object> updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
        courseService.updateCourse(course, id, topicId);
        return ResponseEntity.accepted().body(course);
    }

    @DeleteMapping(value = "/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
    }

}