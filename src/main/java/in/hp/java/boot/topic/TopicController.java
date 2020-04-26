package in.hp.java.boot.topic;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
public class TopicController {

    @Autowired
    private TopicService topicService;

    private static final String SLASHPATH = "/";

    @GetMapping
    @ApiOperation(value = "Return list of all Topics", response = Topic.class, responseContainer = "List")
    public List<Topic> getTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Gets a Topic with specified Id", response = Topic.class)
    public Topic getTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    /**
     * @param topic
     * @return
     * @Valid - used to validated the bean with the specified validators in bean class
     */
    @PostMapping
    @ApiOperation(value = "Adds a Topic")
    public ResponseEntity<Object> addTopic(@Valid @RequestBody Topic topic) {
        topicService.addTopic(topic);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path(SLASHPATH + topic.getId())
                .buildAndExpand()
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Updates the Topic")
    public ResponseEntity<Object> updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        topicService.updateTopic(topic, id);
        return ResponseEntity.accepted().body(topic);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Deletes a Topic")
    public void deleteTopic(@ApiParam(required = true) @PathVariable String id) {
        topicService.deleteTopic(id);
    }

}