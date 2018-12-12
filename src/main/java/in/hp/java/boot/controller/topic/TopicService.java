package in.hp.java.boot.controller.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	/*
	 * Autowiring the dependency so spring will initialize the repository
	 */
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		
		/*
		 * The findAll() method of Spring JPA returns an Iterable of Topic objects after retrieving it from the DB, all the connections and other stuffs are taken care by Spring
		 * We need to iterate through the Iterable and create a list and send it back, for that we are using MethodReferences in Java 8.
		 */
		topicRepository.findAll().forEach(topics :: add);
		
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topicRepository.findById(id).get();
	}

	public void addTopic(Topic topic) {
		/*
		 * Method saves the topic instance to the database
		 */
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
	
}
