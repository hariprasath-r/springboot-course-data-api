package in.hp.java.boot.controller.topic;

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
    public List<Topic> getTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping(value = "/{id}")
    public Topic getTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    /**
     * @Valid - used to validated the bean with the specified validators in bean class
     * @param topic
     * @return
     */
    @PostMapping
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
    public ResponseEntity<Object> updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        topicService.updateTopic(topic, id);
        return ResponseEntity.accepted().body(topic);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
    }

}