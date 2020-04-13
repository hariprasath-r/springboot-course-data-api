package in.hp.java.boot.controller.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Service - Indicates that this is a singleton
 * @author haripr
 *
 */
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
		 * The findAll() method of Spring JPA returns an Iterable of Topic objects after
		 * retrieving it from the DB, all the connections and other stuffs are taken
		 * care by Spring We need to iterate through the Iterable and create a list and
		 * send it back, for that we are using MethodReferences in Java 8.
		 */
		topicRepository.findAll().forEach(topics::add);

		return topics;
	}

	public Topic getTopic(String id) {
		/**
		 * orElse of Optional checks and return if the Optional has value or null
		 */
		return topicRepository.findById(id).orElse(null);
	}

	public void addTopic(Topic topic) {
		/*
		 * Method saves the topic instance to the database
		 */
		topicRepository.save(topic);
	}

	public void updateTopic(Topic topic) {
		/*
		 * Same method save() checks the primary key existence, and creates or updates
		 * accordingly
		 */
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}

}
