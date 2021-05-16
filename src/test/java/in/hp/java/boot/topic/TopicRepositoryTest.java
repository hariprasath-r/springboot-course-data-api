package in.hp.java.boot.topic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class TopicRepositoryTest {

    @Autowired
    private TopicRepository topicRepository;

    @Test
    public void findAllTopicsTest() {
        List<Topic> all = topicRepository.findAll();
        assertEquals(0, all.size());
    }
    
    @Test
    public void findByIdTest() {
        Optional<Topic> topic = topicRepository.findById("1");
        assertFalse(topic.isPresent());
    }
}