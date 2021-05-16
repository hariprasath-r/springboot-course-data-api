package in.hp.java.boot.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @WebMvcTest will inject the dependency of specified controller class to the MockMvc
 * It basically launches the spring context with only the mentioned controller
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
        // Preparing the request with payload, uri and response type
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .request(HttpMethod.GET, "/hello-mockito")
                .accept(MediaType.APPLICATION_JSON);

        /**
         * mockMvc.perform will make the request call
         * andExpect - we can pass matchers to check status, content and other things
         * andExpect - we can also match the resulting json
         */
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello Mockito"))
                .andReturn();

        /**
         * asserting the response to verify
         * assert is not required if the response is simple like a string, but we need it for complex scenario
         */
//        assertEquals("Hello Mockito", mvcResult.getResponse().getContentAsString());
    }
}