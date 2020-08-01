package in.hp.java.boot.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;

/**
 * @WebMvcTest will inject the dependency of specified controller class to the MockMvc
 */
@RunWith(SpringRunner.class)
@WebMvcTest(TestController.class)
public class TestControllerTest {

    /**
     * MockMvc will only be autowired if we annotate with @RunWith
     */
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void helloMockito() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .request(HttpMethod.GET, "/hello-mockito")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        assertEquals("Hello Mockito", mvcResult.getResponse().getContentAsString());
    }
}