package in.hp.java.boot.controller.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Added Root RequestMapping topics URI
 * @author haripr
 *
 */
@RestController
@RequestMapping("/topics")
public class TopicController {

	@Autowired
	private TopicService topicService;

	@RequestMapping
	public List<Topic> getTopics() {
		return topicService.getAllTopics();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(id, topic);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}

}