package in.hp.java.boot.topic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(TopicController.class)
public class TopicControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TopicService topicService;

    @Test
    public void getTopics() throws Exception {
        Mockito.when(topicService.getAllTopics()).thenReturn(new ArrayList<Topic>());

        MockHttpServletRequestBuilder accept = MockMvcRequestBuilders
                .get("/topics")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(accept).andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.content().json("[]"));
    }

    @Test
    public void getTopic() {
    }

    @Test
    public void addTopic() {
    }

    @Test
    public void updateTopic() {
    }

    @Test
    public void deleteTopic() {
    }
}