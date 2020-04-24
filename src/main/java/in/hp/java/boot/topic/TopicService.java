package in.hp.java.boot.topic;

import in.hp.java.boot.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
		return topicRepository.findAll().stream().collect(Collectors.toList());
	}

	public Topic getTopic(String id) {
		/**
		 * orElse of Optional checks and return if the Optional has value or null
		 * orElseThrow will throw the supplied exception if Optional is null or empty
		 */
		return topicRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public void addTopic(Topic topic) {
		/*
		 * Method saves the topic instance to the database
		 */
		topicRepository.save(topic);
	}

	public void updateTopic(Topic topic, String id) {
		/*
		 * Same method save() checks the primary key existence, and creates or updates
		 * accordingly
		 */
		if (Objects.nonNull(getTopic(id)))
			topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		if (Objects.nonNull(getTopic(id)))
			topicRepository.deleteById(id);
	}

}
