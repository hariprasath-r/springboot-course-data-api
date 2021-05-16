package in.hp.java.boot.topic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class TopicServiceTest {

    @InjectMocks
    private TopicService topicService;

    @Mock
    private TopicRepository topicRepository;

    @Test
    public void getAllTopics() {
        Topic topic1 = new Topic();
        topic1.setId("1");
        Topic topic2 = new Topic();
        topic2.setId("2");

        List<Topic> topics = Arrays.asList(topic1, topic2);

        Mockito.when(topicRepository.findAll())
                .thenReturn(topics);

        List<Topic> allTopics = topicService.getAllTopics();
        assertEquals(topics, allTopics);
    }

    @Test
    public void getTopic() {
        Topic topic1 = new Topic();
        topic1.setId("1");

        Mockito.when(topicRepository.findById("1"))
                .thenReturn(Optional.of(topic1));

        Topic topic = topicService.getTopic("1");
        assertEquals(topic1, topic);
    }
}